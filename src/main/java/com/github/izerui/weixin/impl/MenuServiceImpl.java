/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
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

}
