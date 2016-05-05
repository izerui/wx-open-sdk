
package junit;

import org.junit.Test;

import java.util.List;

/**
 * Created by serv on 16/4/28.
 */
public class IpTest extends BaseTest{

    @Test
    public void getCallBackIps(){

        List<String> callBackIps = engine.getIpService(accessToken).getCallBackIps();
        System.out.println(callBackIps);
    }
}
