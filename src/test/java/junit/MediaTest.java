
package junit;

import com.github.izerui.weixin.mappings.MaterialStatus;
import com.github.izerui.weixin.mappings.Media;
import com.github.izerui.weixin.mappings.MediaStatus;
import com.github.izerui.weixin.mappings.News;
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
        Media media = Media.image("11.pic.jpg",Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.getMediaService(accessToken).upload(media);
        System.out.println(status);
    }

    @Test
    public void uploadImg() throws IOException {
        File file = new File("/Users/serv/Documents/11.pic.jpg");
        Media media = Media.image("11.pic.jpg",Files.readAllBytes(file.toPath()));
        String s = engine.getMediaService(accessToken).uploadImg(media);
        System.out.println(s);
    }


    @Test
    public void addMaterial() throws IOException {
        File file = new File("/Users/serv/Documents/11.pic.jpg");
        Media media = Media.thumb("11.pic.jpg",Files.readAllBytes(file.toPath()));
        MaterialStatus materialStatus = engine.getMediaService(accessToken).addMaterial(media);
        System.out.println(materialStatus);
    }


    @Test
    public void url(){
        URL df = engine.getMediaService(accessToken).url("-dJj_0Wo87vQtEXWHj3LT-ga0m5YkVJzIlwXLn_4tTdpH9SZB_hYdLjO1yLu_oP7");
        System.out.println(df);
    }

    @Test
    public void addNews(){
        News news = new News(
                "bootren",
                "zbgUo6Yw_w0Xc0-IWbsjT2f0mkMEkb-Wb7e07dy0yUM",
                "lyh",
                "djfjdsjfdsfdsf",
                1,
                "jdsfjdsjfjdsjf",
                "http://boot.ren"
        );
        String s = engine.getMediaService(accessToken).addNewses(News.newses(news));
        System.out.println(s);
    }
}
