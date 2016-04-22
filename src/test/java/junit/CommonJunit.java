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
