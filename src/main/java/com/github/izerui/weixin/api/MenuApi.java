package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.MenuCreateRequestConverter;
import com.github.izerui.weixin.converter.MenuGetResponseConverter;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.support.RequestConverter;
import com.github.izerui.weixin.mappings.Button;
import com.github.izerui.weixin.mappings.Status;
import com.github.izerui.weixin.support.ResponseConverter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by serv on 16/4/19.
 */
public interface MenuApi {

    @POST("menu/create")
    @RequestConverter(MenuCreateRequestConverter.class)
    Call<Status> create(@Body List<Button> buttons, @Query("access_token")String accessToken);

    @GET("menu/get")
    @ResponseConverter(MenuGetResponseConverter.class)
    Call<List<Menu>> get(@Query("access_token")String accessToken);

}
