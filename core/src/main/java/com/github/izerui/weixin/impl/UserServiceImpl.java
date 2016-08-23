
package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.UserService;
import com.github.izerui.weixin.api.UserApi;
import com.github.izerui.weixin.mappings.*;
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

    @Override
    public Status update(UserRemark userRemark) {
        return execute(api().updateRemark(userRemark,accessToken));
    }

    @Override
    public UserInfo userInfo(String openId) {
        return execute(api().userInfo(openId, "zh_CN", accessToken));
    }
}
