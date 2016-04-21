package junit;

import com.github.izerui.weixin.mappings.Users;
import org.junit.Test;

/**
 * Created by serv on 16/4/21.
 */
public class UserJunit extends BaseJunit {

    @Test
    public void get(){

        Users users = engine.getUserService(accessToken).get(null);
        System.out.println(users);
    }
}
