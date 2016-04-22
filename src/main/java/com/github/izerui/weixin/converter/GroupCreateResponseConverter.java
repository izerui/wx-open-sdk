package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.mappings.Group;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/22.
 */
public class GroupCreateResponseConverter extends JacksonResponseBodyConverter<Group> {

    public GroupCreateResponseConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    protected Group convert(String value) throws IOException {
        JsonNode jsonNode = mapper.readTree(value);
        return mapper.readValue(jsonNode.path("group").toString(),Group.class);
    }
}
