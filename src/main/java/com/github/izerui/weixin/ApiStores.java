package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.AccessToken;
import com.github.izerui.weixin.mappings.Groups;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 微信API接口商店
 * Created by serv on 16/4/15.
 */
public interface ApiStores {

    @GET("token")
    Call<AccessToken> accessToken(@Query("grant_type") String grantType, @Query("appid") String appId, @Query("secret") String appSecret);


    @GET("groups/get")
    Call<Groups> groups(@Query("access_token") String accessToken);
}
