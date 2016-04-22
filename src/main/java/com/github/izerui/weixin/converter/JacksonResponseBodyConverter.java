/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
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
