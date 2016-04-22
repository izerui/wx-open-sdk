/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package com.github.izerui.weixin.mappings;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public abstract class Message implements Serializable {

    protected String toUser;

    protected String kfAccount;

    protected Message(String toUser) {
        this.toUser = toUser;
    }

    public String getToUser() {
        return toUser;
    }

    public Message withKfAccount(String kfAccount){
        this.kfAccount = kfAccount;
        return this;
    }

    protected String kfPlaceholder(){
        if(kfAccount==null){
            return "";
        }else{
            return String.format(",\"customservice\":{\"kf_account\":\"%s\"}",kfAccount);
        }
    }

    public abstract String toJson();

    public static Message text(String toUser, String content){
        return new TextMessage(toUser,content);
    }

    public static Message image(String toUser, String mediaId){
        return new ImageMessage(toUser,mediaId);
    }

    public static Message voice(String toUser, String mediaId){
        return new VoiceMessage(toUser,mediaId);
    }

    public static Message video(String toUser, String mediaId, String thumbMediaId,String title,String description){
        return new VideoMessage(toUser,mediaId,thumbMediaId,title,description);
    }

    public static Message music(String toUser, String title, String description, String musicurl, String hqMusicUrl, String thumbMediaId){
        return new MusicMessage(toUser,title,description,musicurl,hqMusicUrl,thumbMediaId);
    }

    public static Message articleNews(String toUser, List<Article> articles){
        return new ArticleNewsMessage(toUser,articles);
    }

    public static Message mediaIdNews(String toUser,String mediaId){
        return new MediaNewsMessage(toUser,mediaId);
    }

    public static class TextMessage extends Message{

        private String content;

        public TextMessage(String toUser, String content) {
            super(toUser);
            this.content = content;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}%s}",toUser,content,kfPlaceholder());
        }
    }

    public static class ImageMessage extends Message{

        private String mediaId;

        public ImageMessage(String toUser, String mediaId) {
            super(toUser);
            this.mediaId = mediaId;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}%s}",toUser,mediaId,kfPlaceholder());
        }
    }

    public static class VoiceMessage extends Message{

        private String mediaId;

        public VoiceMessage(String toUser, String mediaId) {
            super(toUser);
            this.mediaId = mediaId;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}%s}",toUser,mediaId,kfPlaceholder());
        }
    }

    public static class VideoMessage extends Message{

        private String mediaId;
        private String thumbMediaId;
        private String title;
        private String description;

        public VideoMessage(String toUser, String mediaId, String thumbMediaId, String title, String description) {
            super(toUser);
            this.mediaId = mediaId;
            this.thumbMediaId = thumbMediaId;
            this.title = title;
            this.description = description;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\",\"title\":\"%s\",\"description\":\"%s\"}%s}",
                    toUser,
                    mediaId,
                    thumbMediaId,
                    title,
                    description,
                    kfPlaceholder());
        }
    }

    public static class MusicMessage extends Message{

        private String title;
        private String description;
        private String musicurl;
        private String hqMusicUrl;
        private String thumbMediaId;

        public MusicMessage(String toUser, String title, String description, String musicurl, String hqMusicUrl, String thumbMediaId) {
            super(toUser);
            this.title = title;
            this.description = description;
            this.musicurl = musicurl;
            this.hqMusicUrl = hqMusicUrl;
            this.thumbMediaId = thumbMediaId;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":{\"title\":\"%s\",\"description\":\"%s\",\"musicurl\":\"%s\",\"hqmusicurl\":\"%s\",\"thumb_media_id\":\"%s\"}%s}",
                    toUser,
                    title,
                    description,
                    musicurl,
                    hqMusicUrl,
                    thumbMediaId,
                    kfPlaceholder());
        }
    }

    public static class ArticleNewsMessage extends Message{

        private List<Article> articles;

        public ArticleNewsMessage(String toUser, List<Article> articles) {
            super(toUser);
            this.articles = articles;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\": [%s]}%s}",
                    toUser,
                    StringUtils.join(articles,","),
                    kfPlaceholder());
        }
    }

    public static class MediaNewsMessage extends Message{

        private String mediaId;

        public MediaNewsMessage(String toUser, String mediaId) {
            super(toUser);
            this.mediaId = mediaId;
        }

        @Override
        public String toJson() {
            return String.format("{\"touser\":\"%s\",\"msgtype\":\"mpnews\",\"mpnews\":{\"media_id\":\"%s\"}%s}",
                    toUser,
                    mediaId,
                    kfPlaceholder());
        }
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picUrl;

        public Article(String title, String description, String url, String picUrl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picUrl = picUrl;
        }

        @Override
        public String toString(){
            return String.format("{\"title\":\"%s\",\"description\":\"%s\",\"url\":\"%s\",\"picurl\":\"%s\"}",
                    title,
                    description,
                    url,
                    picUrl);
        }
    }


    //TODO 发送卡券
    public static class CardMessage extends Message{


        protected CardMessage(String toUser) {
            super(toUser);
        }

        @Override
        public String toJson() {
            return null;
        }
    }
}
