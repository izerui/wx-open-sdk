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
