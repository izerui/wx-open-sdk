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

import com.github.izerui.weixin.TokenService;
import com.github.izerui.weixin.api.AccessTokenApi;
import com.github.izerui.weixin.mappings.AccessToken;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/20.
 */
public class TokenServiceImpl extends ServiceImpl<AccessTokenApi> implements TokenService {

    public TokenServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<AccessTokenApi> getApiClass() {
        return AccessTokenApi.class;
    }

    @Override
    public AccessToken getToken(String appId, String appSecret) {
        return execute(api().getToken("client_credential", appId, appSecret));
    }
}
