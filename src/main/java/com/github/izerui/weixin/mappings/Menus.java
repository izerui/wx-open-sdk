package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 2014/7/28.
 */
public class Menus implements Serializable {

    @JsonProperty("button")
    private List<MenuItem> menuItems;

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public static class MenuItem{

        @JsonProperty("type")
        private Type type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("key")
        private String key;
        @JsonProperty("url")
        private String url;
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("sub_button")
        private List<Menus> subButton;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }


        public List<Menus> getSubButton() {
            return subButton;
        }

        public void setSubButton(List<Menus> subButton) {
            this.subButton = subButton;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    /**
     * http://mp.weixin.qq.com/wiki/10/0234e39a2025342c17a7d23595c6b40a.html
     */
    public enum Type {
        /**
         * 点击推事件
         */
        click,
        /**
         * 跳转URL
         */
        view,
        /**
         * 扫码推事件
         */
        scancode_push,
        /**
         * 扫码推事件且弹出“消息接收中”提示框
         */
        scancode_waitmsg,
        /**
         * 弹出系统拍照发图
         */
        pic_sysphoto,
        /**
         * 弹出拍照或者相册发图
         */
        pic_photo_or_album,
        /**
         * 弹出微信相册发图器
         */
        pic_weixin,
        /**
         * 弹出地理位置选择器
         */
        location_select,
        /**
         * 下发消息（除文本消息）
         */
        media_id,
        /**
         * 跳转图文消息URL
         */
        view_limited;
    }
}
