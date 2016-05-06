package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/23.
 */
public class JacksonConverter<REQUEST,RESPONSE> {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    /**
     * 将入参对象转换成请求的requestBody字节数组
     * @param mapper
     * @param type 入参的Type类型
     * @param request 入参对象
     * @return http request请求的body字节数组
     * @throws IOException
     */
    public byte[] request(ObjectMapper mapper, Type type, REQUEST request) throws IOException{
        if(((Class)type).isAssignableFrom(String.class)){
            return ((String)request).getBytes(CHARSET_UTF8);
        }
        return mapper.writeValueAsBytes(request);
    }

    /**
     * 将responseBody字节数组 转换成 RESPONSE对象
     * @param mapper
     * @param type RESPONSE 的 Type类型
     * @param response 请求返回的responseBody字节数组
     * @return 返回 RESPONSE 对象
     * @throws IOException
     */
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

}
