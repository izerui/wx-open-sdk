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

import org.junit.Test;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlTest extends BaseTest {

    @Test
    public void shortUrl(){
        String s = engine.getShortUrlService(accessToken).shortUrl("http://www.jsonschema2pojo.org/");
        System.out.println(s);
    }
}
