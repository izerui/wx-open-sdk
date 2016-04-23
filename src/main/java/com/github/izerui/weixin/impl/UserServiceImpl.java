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

import com.github.izerui.weixin.UserService;
import com.github.izerui.weixin.api.UserApi;
import com.github.izerui.weixin.mappings.ArrayUser;
import com.github.izerui.weixin.mappings.Status;
import com.github.izerui.weixin.mappings.OneUser;
import com.github.izerui.weixin.mappings.Users;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/21.
 */
public class UserServiceImpl extends ServiceImpl<UserApi> implements UserService {

    public UserServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<UserApi> getApiClass() {
        return UserApi.class;
    }

    @Override
    public Users getUsers(String nextOpenId) {
        return execute(api().getUsers(nextOpenId,accessToken));
    }


    @Override
    public Integer getGroup(String openId) {
        return execute(api().getGroup(openId,accessToken));
    }

    @Override
    public Status move(OneUser oneUser) {
        return execute(api().moveOne(oneUser,accessToken));
    }

    @Override
    public Status move(ArrayUser arrayUser) {
        return execute(api().moveArray(arrayUser,accessToken));
    }
}
