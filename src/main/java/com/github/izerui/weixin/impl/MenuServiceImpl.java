package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.MenuService;
import com.github.izerui.weixin.api.MenuApi;
import com.github.izerui.weixin.mappings.Button;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by serv on 16/4/20.
 */
public class MenuServiceImpl extends ServiceImpl<MenuApi> implements MenuService {

    public MenuServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<MenuApi> getApiClass() {
        return MenuApi.class;
    }

    @Override
    public Status create(List<Button> buttons) {
        return execute(api().create(buttons,accessToken));
    }

    @Override
    public List<Menu> get() {
        return execute(api().get(accessToken));
    }
}
