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

import com.github.izerui.weixin.mappings.Semantic;
import org.junit.Test;

/**
 * Created by serv on 16/4/24.
 */
public class SemanticTest extends BaseTest {

    @Test
    public void semantic(){

        Semantic semantic = new Semantic();
        semantic.setQuery("查一下明天从北京到上海的南航机票");
        semantic.setCity("北京");
        semantic.setCategory("flight,hotel");
        semantic.setAppid("fff");
        semantic.setUid("234");

        String search = engine.getSemanticService(accessToken).search(semantic);
        System.out.println(search);
    }
}
