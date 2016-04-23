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
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import com.github.izerui.weixin.mappings.Message;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/21.
 */
public interface MessageApi {

    @POST("message/custom/send")
    @Converter(SendConverter.class)
    Call<Status> send(@Body Message message, @Query("access_token")String accessToken);


    class SendConverter extends JacksonConverter<Message,Status> {

        @Override
        public byte[] request(ObjectMapper mapper, Type type, Message message) throws IOException {
            return message.toJson().getBytes(CHARSET_UTF8);
        }
    }


}
