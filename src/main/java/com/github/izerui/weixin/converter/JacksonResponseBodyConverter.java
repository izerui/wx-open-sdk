/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 桑·奥塞瓦<sam@hocevar.net>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
 */
package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class JacksonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
  protected final ObjectMapper mapper;
  protected final Type type;

  public JacksonResponseBodyConverter(Type type, ObjectMapper mapper) {
    this.type = type;
    this.mapper = mapper;
  }

  @Override public T convert(ResponseBody value) throws IOException {
    try {
      return (T)mapper.readValue(value.string(),Class.forName(type.getTypeName()));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      value.close();
    }
    return null;
  }
}
