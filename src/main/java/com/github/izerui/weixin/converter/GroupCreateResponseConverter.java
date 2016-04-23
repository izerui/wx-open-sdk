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
