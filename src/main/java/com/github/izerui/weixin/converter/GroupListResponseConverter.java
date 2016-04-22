/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
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
