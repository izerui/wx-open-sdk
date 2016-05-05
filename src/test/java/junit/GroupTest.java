
package junit;

import com.github.izerui.weixin.mappings.Group;
import com.github.izerui.weixin.mappings.Status;
import org.junit.Test;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class GroupTest extends BaseTest {

    @Test
    public void test0(){
        System.out.println("s");
    }

    @Test
    public void groups(){

        List<Group> groups = engine.getGroupService(accessToken).groups();
        System.out.println(groups.toString());
    }

    @Test
    public void create(){
        Group group = engine.getGroupService(accessToken).create("ddd");
        System.out.println(group);
    }

    @Test
    public void update(){
        Status update = engine.getGroupService(accessToken).update(new Group(100, "123321123321"));
        System.out.println(update);
    }

    @Test
    public void delete(){
        Status delete = engine.getGroupService(accessToken).delete(106);
        System.out.println(delete);
    }

}
