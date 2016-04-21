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
