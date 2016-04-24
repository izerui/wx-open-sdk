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
 * Created by serv on 16/4/22.
 */
public class CommonTest extends BaseTest {


    @Test
    public void test01(){
        String post = engine.getCommonService().post(
                "https://api.weixin.qq.com/semantic/semproxy/search?access_token=" + accessToken,
                "{\n" +
                        "\"query\":\"查一下明天从北京到上海的南航机票\",\n" +
                        "\"city\":\"北京\",\n" +
                        "\"category\": \"flight,hotel\",\n" +
                        "\"appid\":\"wxaaaaaaaaaaaaaaaa\",\n" +
                        "\"uid\":\"123456\"\n" +
                        "} "
        );
        System.out.println(post);
    }

    @Test
    public void test02(){
        String get = engine.getCommonService().get(
                "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken);
        System.out.println(get);
    }

}
