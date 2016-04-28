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
package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/28.
 */
public interface IpApi {
    @GET("getcallbackip")
    @Converter(GetCallBackIpsConverter.class)
    Call<List<String>> getCallBackIps(@Query("access_token") String accessToken);

    class GetCallBackIpsConverter extends JacksonConverter<Void,List<String>> {
        @Override
        public List<String> response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, String.class);
            return mapper.readValue(mapper.readTree(response).path("ip_list").toString(), collectionType);
        }
    }
}
