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
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

public class JacksonRequestBodyConverter<T> implements Converter<T, RequestBody> {
  protected static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

  protected final ObjectMapper mapper;
  protected final Type type;

  public JacksonRequestBodyConverter(Type type,ObjectMapper mapper) {
    this.type = type;
    this.mapper = mapper;
  }

  @Override public RequestBody convert(T value) throws IOException {
    byte[] bytes = mapper.writeValueAsBytes(value);
    return RequestBody.create(MEDIA_TYPE, bytes);
  }
}
