package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.AccessToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/19.
 */
public interface AccessTokenApi {
    /**
     * 获取access token
     * @param grantType 获取access_token填写client_credential
     * @param appId 第三方用户唯一凭证
     * @param appSecret 第三方用户唯一凭证密钥，即appsecret
     * @return {"access_token":"ACCESS_TOKEN","expires_in":7200}
     */
    @GET("token")
    Call<AccessToken> getToken(@Query("grant_type") String grantType, @Query("appid") String appId, @Query("secret") String appSecret);

}
