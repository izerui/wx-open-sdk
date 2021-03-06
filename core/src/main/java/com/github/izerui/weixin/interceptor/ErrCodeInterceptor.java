
package com.github.izerui.weixin.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.WxException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by serv on 16/4/25.
 */
public class ErrCodeInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if(HttpEngine.hasBody(response)){
            BufferedSource source = response.body().source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String body = buffer.clone().readString(UTF8);
            JsonNode jsonNode = mapper.readTree(body);
            if(jsonNode.has("errcode")){
                int errcode = jsonNode.path("errcode").asInt();
                if(errcode!=0){
                    throw new WxException(errcode,jsonNode.path("errmsg").asText());
                }
            }
        }

        return response;
    }
}
