package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.UserService;
import com.github.izerui.weixin.api.UserApi;
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
    public Users get(String nextOpenId) {
        return execute(api().get(nextOpenId,accessToken));
    }
}
