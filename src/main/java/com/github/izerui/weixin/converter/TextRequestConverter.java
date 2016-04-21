package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/21.
 */
public class TextRequestConverter extends JacksonRequestBodyConverter<String> {

    public TextRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public RequestBody convert(String value) throws IOException {
        return super.convert(value);
    }
}
