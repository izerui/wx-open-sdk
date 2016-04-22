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

import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.support.ButtonType;
import com.github.izerui.weixin.mappings.Button;
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
        button.setType(ButtonType.click);
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

    @Test
    public void getCurrentSelfmenuInfo(){
        String currentSelfmenuInfo = engine.getMenuService(accessToken).getCurrentSelfmenuInfo();
        System.out.println(currentSelfmenuInfo);
    }
}
