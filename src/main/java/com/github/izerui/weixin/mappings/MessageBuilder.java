package com.github.izerui.weixin.mappings;

/**
 * Created by serv on 16/4/21.
 */
public class MessageBuilder {

    public final static String TEXT_FORMAT = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";

    public static String createTextMessage(String toUser, String content){
        return String.format(TEXT_FORMAT,toUser,content);
    }

}
