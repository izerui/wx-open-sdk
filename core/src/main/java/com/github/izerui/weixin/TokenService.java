
package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.AccessToken;

/**
 * Created by serv on 16/4/20.
 */
public interface TokenService {

    AccessToken getToken(String appId, String appSecret);
}
