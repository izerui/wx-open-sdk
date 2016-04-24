package junit;

import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;
import org.junit.Test;

/**
 * Created by serv on 16/4/24.
 */
public class QrcodeJunit extends BaseTest{

    @Test
    public void create(){
        Ticket fff = engine.getQrcodeService(accessToken).create(new QrCode("fff"));
        System.out.println(fff);
    }

    @Test
    public void create01(){
        Ticket ticket = engine.getQrcodeService(accessToken).create(new QrCode(100, 222));
        System.out.println(ticket);
    }
}
