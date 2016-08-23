package com.github.izerui.weixin.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by serv on 16/4/22.
 */
public interface CommonApi {

    @GET
    Call<String> get(@Url String url);

    @POST
    Call<String> post(@Url String url , @Body String json);
}
