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

}
