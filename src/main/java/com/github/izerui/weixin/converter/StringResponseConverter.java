package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/21.
 */
public class StringResponseConverter extends JacksonResponseBodyConverter<String> {

    public StringResponseConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
