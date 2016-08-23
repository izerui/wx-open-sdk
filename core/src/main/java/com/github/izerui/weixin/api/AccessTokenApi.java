package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.AccessToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/19.
 */
public interface AccessTokenApi {
    @GET("token")
    Call<AccessToken> getToken(@Query("grant_type") String grantType, @Query("appid") String appId, @Query("secret") String appSecret);

}
