package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.TokenService;
import com.github.izerui.weixin.api.AccessTokenApi;
import com.github.izerui.weixin.mappings.AccessToken;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/20.
 */
public class TokenServiceImpl extends ServiceImpl implements TokenService {

    public TokenServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public AccessToken getToken(String appId, String appSecret) {
        AccessTokenApi api = retrofit.create(AccessTokenApi.class);
        return execute(api.getToken("client_credential", appId, appSecret));
    }
}
