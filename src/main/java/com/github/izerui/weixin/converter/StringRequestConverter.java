package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.mappings.Message;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/21.
 */
public class StringRequestConverter extends JacksonRequestBodyConverter<Message> {

    public StringRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public RequestBody convert(Message value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.toJson().getBytes("UTF-8"));
    }
}
