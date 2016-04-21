package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/21.
 */
public class StringRequestConverter extends JacksonRequestBodyConverter<String> {

    public StringRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public RequestBody convert(String value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.getBytes("UTF-8"));
    }
}
