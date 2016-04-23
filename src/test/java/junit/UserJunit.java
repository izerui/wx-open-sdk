/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
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

import com.github.izerui.weixin.mappings.ArrayUser;
import com.github.izerui.weixin.mappings.OneUser;
import com.github.izerui.weixin.mappings.Status;
import com.github.izerui.weixin.mappings.Users;
import org.junit.Test;

/**
 * Created by serv on 16/4/21.
 */
public class UserJunit extends BaseJunit {

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

}
