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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/24.
 */
public interface ShortUrlApi {

    @POST("shorturl")
    @Converter(ShortUrlConverter.class)
    Call<String> shortUrl(@Body String longUrl,@Query("access_token")String accessToken);

    class ShortUrlConverter extends JacksonConverter<String,String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, String longUrl) throws IOException {
            return String.format("{\"action\":\"long2short\",\"long_url”:”%s”}",longUrl).getBytes(CHARSET_UTF8);
        }

        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            JsonNode jsonNode = mapper.readTree(response);
            return jsonNode.path("short_url").asText();
        }
    }
}
