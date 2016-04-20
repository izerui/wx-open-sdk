package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.GroupsRequestConverter;
import com.github.izerui.weixin.enumeration.ResponseConverter;
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
    @ResponseConverter(GroupsRequestConverter.class)
    Call<List<Group>> groups(@Query("access_token") String accessToken);
}
