package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.MessageRequestConverter;
import com.github.izerui.weixin.mappings.Message;
import com.github.izerui.weixin.mappings.Status;
import com.github.izerui.weixin.support.Converter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/21.
 */
public interface MessageApi {

    @POST("message/custom/send")
    @Converter(request = MessageRequestConverter.class)
    Call<Status> send(@Body Message message, @Query("access_token")String accessToken);
}
