package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.izerui.weixin.mappings.Group;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class GroupListResponseConverter extends JacksonResponseBodyConverter<List<Group>> {

    public GroupListResponseConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public List<Group> convert(ResponseBody value) throws IOException {
        JsonNode jsonNode = mapper.readTree(value.string());

        CollectionType collectionType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, Group.class);

        return mapper.readValue(jsonNode.path("groups").toString(),collectionType);
    }
}
