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
