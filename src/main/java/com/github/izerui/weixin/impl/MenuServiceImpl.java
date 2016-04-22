/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
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

    @Override
    public Status delete() {
        return execute(api().delete(accessToken));
    }

    @Override
    public String getCurrentSelfmenuInfo() {
        return execute(api().getCurrentSelfmenuInfo(accessToken));
    }
}
