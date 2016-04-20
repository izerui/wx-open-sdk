/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
