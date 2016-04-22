package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.GroupListResponseConverter;
import com.github.izerui.weixin.support.Converter;
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
    @Converter(response = GroupListResponseConverter.class)
    Call<List<Group>> groups(@Query("access_token") String accessToken);
}
