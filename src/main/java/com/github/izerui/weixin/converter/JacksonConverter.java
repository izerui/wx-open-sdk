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
package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.WxException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/23.
 */
public class JacksonConverter<REQUEST,RESPONSE> {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    public byte[] request(ObjectMapper mapper, Type type, REQUEST request) throws IOException{
        if(((Class)type).isAssignableFrom(String.class)){
            return ((String)request).getBytes(CHARSET_UTF8);
        }
        return mapper.writeValueAsBytes(request);
    }

    public RESPONSE response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
        try {
            if(((Class)type).isAssignableFrom(String.class)){
                return (RESPONSE) new String(response,CHARSET_UTF8);
            }
            return (RESPONSE) mapper.readValue(response, Class.forName(type.getTypeName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final void preConvertResponse(ObjectMapper mapper,Type type, byte[] response) throws IOException {
        try {
            JsonNode jsonNode = mapper.readTree(response);
            if(jsonNode.has("errcode")){
                int errcode = jsonNode.path("errcode").asInt();
                if(errcode!=0){
                    throw new WxException(errcode,jsonNode.path("errmsg").asText());
                }
            }
        }catch (JsonProcessingException ex){
            throw new WxException(-103,"response is not json");
        }
    }

}
