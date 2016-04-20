package junit;

import com.github.izerui.weixin.mappings.Group;
import org.junit.Test;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class GroupJunit extends BaseJunit{

    @Test
    public void groups(){

        List<Group> groups = engine.getGroupService(accessToken).groups();
        System.out.println(groups.toString());
    }

}
