package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.GroupListRequestConverter;
import com.github.izerui.weixin.support.ResponseConverter;
import com.github.izerui.weixin.mappings.Group;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by serv on 16/4/19.
 */
public interface GroupApi {

    @GET("groups/get")
    @ResponseConverter(GroupListRequestConverter.class)
    Call<List<Group>> groups(@Query("access_token") String accessToken);
}
