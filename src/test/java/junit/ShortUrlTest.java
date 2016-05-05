
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
