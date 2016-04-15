package junit;

import com.github.izerui.weixin.WxApiStores;
import com.github.izerui.weixin.mappings.AccessToken;
import org.junit.Before;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by serv on 16/4/16.
 */
public abstract class AccessTokenJunit implements Constants{

    protected String accessToken;

    @Before
    public void setUp() throws Exception {
        Call<AccessToken> token = WxApiStores.api().accessToken("client_credential", Constants.appId, Constants.appSecret);
        Response<AccessToken> response = token.execute();

        if(response.isSuccessful()){
            if(response.body().isSuccess()){
                System.out.println(response.body().getAccessToken());
            }else{
                System.out.println(response.body().getErrCode());
            }
        }else {
            System.out.println(response.errorBody().string());
        }

        accessToken = response.body().getAccessToken();

    }
}
