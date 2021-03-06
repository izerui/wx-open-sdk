
package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serv on 16/4/25.
 */
public class News implements Serializable {

    private String title;

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    private String author;

    private String digest;

    @JsonProperty("show_cover_pic")
    private int showCoverPic;

    private String content;

    @JsonProperty("content_source_url")
    private String contentSourceUrl;

    public static List<News> newses(News... newses){
        return Arrays.asList(newses);
    }

    public News() {
    }

    public News(String title, String thumbMediaId, String author, String digest, int showCoverPic, String content, String contentSourceUrl) {
        this.title = title;
        this.thumbMediaId = thumbMediaId;
        this.author = author;
        this.digest = digest;
        this.showCoverPic = showCoverPic;
        this.content = content;
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(int showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }
}
