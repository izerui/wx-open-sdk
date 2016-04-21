package junit;

import com.github.izerui.weixin.mappings.MessageBuilder;
import com.github.izerui.weixin.mappings.Status;
import org.junit.Test;

/**
 * Created by serv on 16/4/21.
 */
public class MessageJunit extends BaseJunit {

    @Test
    public void send(){
        String[] users = new String[]{"oTDoKtx09l8il-jM1TtdeGs_fHT4", "oTDoKtyOsM5Eo7AIVTidlm6nXHtA", "oTDoKt-0csI5Phsl1TqpUiBKm_cw"};

        for (String user : users) {
            Status result = engine.getMessageService(accessToken).send(MessageBuilder.createTextMessage(user, "djsfjdsf"));
            System.out.println(result);
        }
    }
}
