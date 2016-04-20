package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.CreateMenuRequestConverter;
import com.github.izerui.weixin.support.RequestConverter;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by serv on 16/4/19.
 */
public interface MenuApi {

    /**
     * 自定义菜单创建接口
     * @param menus 菜单集合
     * @param accessToken token
     * @return {"errcode":0,"errmsg":"ok"}
     */
    @POST("menu/create")
    @RequestConverter(CreateMenuRequestConverter.class)
    Call<Status> createMenus(@Body List<Menu> menus, @Query("access_token")String accessToken);

}
