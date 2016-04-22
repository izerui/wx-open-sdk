/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 桑·奥塞瓦<sam@hocevar.net>
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