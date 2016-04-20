package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.MenuService;
import com.github.izerui.weixin.api.MenuApi;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by serv on 16/4/20.
 */
public class MenuServiceImpl extends ServiceImpl implements MenuService {

    public MenuServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public Status createMenus(List<Menu> menus) {
        MenuApi api = retrofit.create(MenuApi.class);
        return execute(api.createMenus(menus,accessToken));
    }
}
