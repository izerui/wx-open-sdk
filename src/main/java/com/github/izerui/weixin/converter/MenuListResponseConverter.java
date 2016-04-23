/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
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
    protected List<Menu> convert(String responseBody) throws IOException {
        List<Menu> menus = new ArrayList<>();
        JsonNode jsonNode = mapper.readTree(responseBody);
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
