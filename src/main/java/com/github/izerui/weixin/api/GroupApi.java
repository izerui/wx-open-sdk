package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.Groups;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/19.
 */
public interface GroupApi {

    @GET("groups/get")
    Call<Groups> groups(@Query("access_token") String accessToken);
}
