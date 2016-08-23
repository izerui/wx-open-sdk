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
