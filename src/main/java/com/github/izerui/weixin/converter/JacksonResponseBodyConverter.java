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
