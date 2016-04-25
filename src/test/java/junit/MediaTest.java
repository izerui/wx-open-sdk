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

import com.github.izerui.weixin.mappings.Media;
import com.github.izerui.weixin.mappings.MediaStatus;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

/**
 * Created by serv on 16/4/25.
 */
public class MediaTest extends BaseTest {

    @Test
    public void upload() throws IOException {
        File file = new File("/Users/serv/Documents/11.pic.jpg");
        Media media = new Media("11.pic.jpg", Media.Type.image,Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.getMediaService(accessToken).upload(media);
        System.out.println(status);
    }

    @Test
    public void url(){
        URL df = engine.getMediaService(accessToken).url("-dJj_0Wo87vQtEXWHj3LT-ga0m5YkVJzIlwXLn_4tTdpH9SZB_hYdLjO1yLu_oP7");
        System.out.println(df);
    }
}
