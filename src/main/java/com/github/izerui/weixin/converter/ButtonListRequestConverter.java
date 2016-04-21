package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.mappings.Button;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonListRequestConverter extends JacksonRequestBodyConverter<List<Button>> {

    public ButtonListRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public RequestBody convert(List<Button> value) throws IOException {
        Map map = new HashMap<>();
        map.put("button", value);
        byte[] bytes = mapper.writeValueAsBytes(map);
        return RequestBody.create(MEDIA_TYPE, bytes);
    }
}