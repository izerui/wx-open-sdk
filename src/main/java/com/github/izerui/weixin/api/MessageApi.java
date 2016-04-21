package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.StringRequestConverter;
import com.github.izerui.weixin.converter.StringResponseConverter;
import com.github.izerui.weixin.mappings.Status;
import com.github.izerui.weixin.support.RequestConverter;
import com.github.izerui.weixin.support.ResponseConverter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/21.
 */
public interface MessageApi {

    @POST("message/custom/send")
    @RequestConverter(StringRequestConverter.class)
    Call<Status> send(@Body String message, @Query("access_token")String accessToken);
}
