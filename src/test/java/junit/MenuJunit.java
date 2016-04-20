package junit;

import com.github.izerui.weixin.WxEngine;
import com.github.izerui.weixin.enumeration.MenuType;
import com.github.izerui.weixin.mappings.Groups;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/16.
 */
public class MenuJunit extends BaseJunit {

    @Test
    public void createMenus() throws IOException {

        List<Menu> menus = new ArrayList<Menu>();

        Menu menu = new Menu();
        menu.setName("多大1");
        menu.setType(MenuType.click);
        menu.setKey("jsjdf");
        menus.add(menu);

        Status status = engine.getMenuService(accessToken).createMenus(menus);
        System.out.println(status.getErrCode());
    }
}
