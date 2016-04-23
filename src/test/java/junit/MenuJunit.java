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

import com.github.izerui.weixin.mappings.Button;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/16.
 */
public class MenuJunit extends BaseJunit {

    @Test
    public void create() throws IOException {

        List<Button> buttons = new ArrayList<Button>();

        Button button = new Button();
        button.setName("多大3331");
        button.setType(Button.ButtonType.click);
        button.setKey("jsjdf");
        buttons.add(button);

        Status status = engine.getMenuService(accessToken).create(buttons);
        System.out.println(status.getErrMsg());
    }

    @Test
    public void get(){
        List<Menu> buttons = engine.getMenuService(accessToken).get();
        System.out.println(buttons);
    }

    @Test
    public void delete(){
        Status delete = engine.getMenuService(accessToken).delete();
        System.out.println(delete);
    }

}
