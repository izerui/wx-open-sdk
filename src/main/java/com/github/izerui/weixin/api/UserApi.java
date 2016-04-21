package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/21.
 */
public interface UserApi {

    @GET("user/get")
    Call<Users> get(@Query("next_openid")String nextOpenId, @Query("access_token")String accessToken);
}
