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

import com.github.izerui.weixin.MessageService;
import com.github.izerui.weixin.mappings.Message;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class MessageTest extends BaseTest {

    @Test
    public void send(){
        String user = "oTDoKt-0csI5Phsl1TqpUiBKm_cw";

        MessageService messageService = engine.getMessageService(accessToken);

        System.out.println(messageService.send(Message.text(user, "textMessage").withKfAccount("ssss")));
        System.out.println(messageService.send(Message.image(user, "imageMessage")));
        System.out.println(messageService.send(Message.voice(user, "voiceMessage")));
        System.out.println(messageService.send(Message.video(user, "voiceMessage","djjdj","djfjdf","sdjfjsdf")));
        System.out.println(messageService.send(Message.music(user, "voiceMessage","djjdj","djfjdf","sdjfjsdf","jdfj")));

        List<Message.Article> articles = new ArrayList<>();
        articles.add(new Message.Article("题名1","说明1","http://baidu.com",null));
        articles.add(new Message.Article("题名2","说明2","http://boot.ren",null));

        System.out.println(messageService.send(Message.articleNews(user, articles)));
        System.out.println(messageService.send(Message.mediaIdNews(user, "zbgUo6Yw_w0Xc0-IWbsjT_2ywoEcYIRJw3ltDqXMTjQ")));
    }

    @Test
    public void send1(){
        String user = "oTDoKt-0csI5Phsl1TqpUiBKm_cw";
        MessageService messageService = engine.getMessageService(accessToken);
        System.out.println(messageService.send(Message.mediaIdNews(user, "zbgUo6Yw_w0Xc0-IWbsjT_2ywoEcYIRJw3ltDqXMTjQ")));
    }
}
