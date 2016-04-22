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
import com.github.izerui.weixin.mappings.Menu;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class MenuListResponseConverter extends JacksonResponseBodyConverter<List<Menu>>{

    public MenuListResponseConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public List<Menu> convert(ResponseBody value) throws IOException {
        List<Menu> menus = new ArrayList<>();
        JsonNode jsonNode = mapper.readTree(value.string());
        Menu defaultMenu = mapper.readValue(jsonNode.path("menu").toString(), Menu.class);
        menus.add(defaultMenu);

        if(jsonNode.has("conditionalmenu")){
            CollectionType collectionType = mapper.getTypeFactory()
                    .constructCollectionType(ArrayList.class, Menu.class);
            List<Menu> conditionalMenus = mapper.readValue(jsonNode.path("conditionalmenu").toString(),collectionType);

            menus.addAll(conditionalMenus);
        }

        return menus;
    }
}
