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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.WxException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

public class JacksonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    protected final ObjectMapper mapper;
    protected final Type type;

    public JacksonResponseBodyConverter(Type type, ObjectMapper mapper) {
        this.type = type;
        this.mapper = mapper;
    }

    @Override
    public final T convert(ResponseBody value) throws IOException {
        String responseBody = value.string();
        try {
            JsonNode jsonNode = mapper.readTree(responseBody);
            if(jsonNode.has("errcode")){
                int errcode = jsonNode.path("errcode").asInt();
                if(errcode!=0){
                    throw new WxException(errcode,jsonNode.path("errmsg").asText());
                }
            }
            return convert(responseBody);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                value.close();
            }catch (Exception e){
                // do nothing
            }
        }
        return null;
    }

    protected T convert(String responseBody) throws WxException, IOException, ClassNotFoundException {
        return (T) mapper.readValue(responseBody, Class.forName(type.getTypeName()));
    }

}
