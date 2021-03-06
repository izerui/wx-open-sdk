
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
public class MenuTest extends BaseTest {

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
