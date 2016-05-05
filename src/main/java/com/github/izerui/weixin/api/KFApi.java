package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.KFSession;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by rocky on 2016/5/4.
 */
public interface KFApi {

    @POST("customservice/kfaccount/add")
    Call<Boolean> add(@Body KFSession kfSession, @Query("access_token")String accessToken);
}
