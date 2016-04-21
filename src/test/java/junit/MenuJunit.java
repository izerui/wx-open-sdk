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
        button.setName("多大1");
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
}
