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
package junit;

import com.github.izerui.weixin.WxEngine;
import com.github.izerui.weixin.mappings.AccessToken;
import org.junit.Before;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by serv on 16/4/16.
 */
public abstract class BaseJunit implements Constants{

    protected String accessToken;
    protected WxEngine engine;

    @Before
    public void setUp() throws Exception {
        engine = new WxEngine();
        AccessToken token = engine.getTokenService().getToken(Constants.appId, Constants.appSecret);
        this.accessToken = token.getAccessToken();
    }
}
