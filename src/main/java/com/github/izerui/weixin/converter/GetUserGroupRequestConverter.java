package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/23.
 */
public class GetUserGroupRequestConverter extends JacksonRequestBodyConverter<String> {

    public GetUserGroupRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    protected byte[] convertBytes(String openId) throws IOException {
        return String.format("{\"openid\":\"%s\"}",openId).getBytes(CHARSET);
    }
}
