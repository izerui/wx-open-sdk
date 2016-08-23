
package junit;

import com.github.izerui.weixin.mappings.*;
import org.junit.Test;

/**
 * Created by serv on 16/4/21.
 */
public class UserTest extends BaseTest {

    @Test
    public void get(){

        Users users = engine.getUserService(accessToken).getUsers(null);
        System.out.println(users);
    }

    @Test
    public void move(){
        Status move = engine.getUserService(accessToken).move(new OneUser(1,"oTDoKtx09l8il-jM1TtdeGs_fHT4"));
        System.out.println(move);
    }

    @Test
    public void getGroup(){
        Integer userGroup = engine.getUserService(accessToken).getGroup("oTDoKt-0csI5Phsl1TqpUiBKm_cw");
        System.out.println(userGroup);
    }

    @Test
    public void moveUsers(){
        Status move = engine.getUserService(accessToken).move(new ArrayUser(1, "oTDoKtx09l8il-jM1TtdeGs_fHT4","oTDoKtyOsM5Eo7AIVTidlm6nXHtA"));
        System.out.println(move);
    }

    @Test
    public void updateRemark(){
        Status hello = engine.getUserService(accessToken).update(new UserRemark("oTDoKtx09l8il-jM1TtdeGs_fHT4", "哈喽"));
        System.out.println(hello);

    }

    @Test
    public void userInfo(){
        UserInfo userInfo = engine.getUserService(accessToken).userInfo("oTDoKtx09l8il-jM1TtdeGs_fHT4");
        System.out.println(userInfo);
    }

}
