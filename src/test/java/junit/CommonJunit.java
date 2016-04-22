/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 桑·奥塞瓦<sam@hocevar.net>
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
public class CommonJunit extends BaseJunit {


    @Test
    public void test01(){
        String post = engine.getCommonService(accessToken).post(
                "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken,
                "{\n" +
                        "  \"touser\":\"OPENID\", \n" +
                        "  \"msgtype\":\"wxcard\",\n" +
                        "  \"wxcard\":{              \n" +
                        "           \"card_id\":\"123dsdajkasd231jhksad\",\n" +
                        "           \"card_ext\": \"{\\\"code\\\":\\\"\\\",\\\"openid\\\":\\\"\\\",\\\"timestamp\\\":\\\"1402057159\\\",\\\"signature\\\":\\\"017bb17407c8e0058a66d72dcc61632b70f511ad\\\"}\"            \n" +
                        "            },\n" +
                        "}"
        );
        System.out.println(post);
    }

    @Test
    public void test02(){
        String get = engine.getCommonService(accessToken).get(
                "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken);
        System.out.println(get);
    }
}
