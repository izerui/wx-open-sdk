package junit;

import com.github.izerui.weixin.WxApiStores;
import com.github.izerui.weixin.mappings.Groups;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by serv on 16/4/16.
 */
public class GroupJunit extends AccessTokenJunit {

    @Test
    public void groups() throws IOException {
        Call<Groups> groups = WxApiStores.api().groups(accessToken);

        Response<Groups> execute = groups.execute();

        System.out.println(execute.body().getGroups());

    }
}
