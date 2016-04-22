/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 桑·奥塞瓦<sam@hocevar.net>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
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
