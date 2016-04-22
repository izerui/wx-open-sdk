package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/22.
 */
public class GroupCreateRequestConverter extends JacksonRequestBodyConverter<String> {

    public GroupCreateRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public byte[] convertBytes(String name) throws IOException {
        return String.format("{\"group\":{\"name\":\"%s\"}}",name).getBytes("UTF-8");
    }
}
