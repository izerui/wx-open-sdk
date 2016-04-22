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
