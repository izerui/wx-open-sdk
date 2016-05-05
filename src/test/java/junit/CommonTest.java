
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
