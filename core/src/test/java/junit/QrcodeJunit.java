
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
        Ticket fff = engine.getQrcodeService(accessToken).create(QrCode.forever("fff"));
        System.out.println(fff);

        System.out.println(engine.getQrcodeService(accessToken).url(fff.getTicket()));
    }

    @Test
    public void create01(){
        Ticket ticket = engine.getQrcodeService(accessToken).create(QrCode.timeout(100, 222));
        System.out.println(ticket);

        System.out.println(engine.getQrcodeService(accessToken).url(ticket.getTicket()));
    }
}
