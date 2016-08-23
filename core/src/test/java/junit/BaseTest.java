
package junit;

import com.github.izerui.weixin.WxEngine;
import com.github.izerui.weixin.mappings.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Before;

/**
 * Created by serv on 16/4/16.
 */
public abstract class BaseTest implements Constants{

    protected String accessToken;
    protected WxEngine engine;

    @Before
    public void setUp() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)).build();
        engine = new WxEngine(client);
        AccessToken token = engine.getTokenService().getToken(Constants.appId, Constants.appSecret);
        this.accessToken = token.getAccessToken();
    }
}
