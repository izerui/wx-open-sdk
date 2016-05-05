package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/28.
 */
public interface IpApi {
    @GET("getcallbackip")
    @Converter(GetCallBackIpsConverter.class)
    Call<List<String>> getCallBackIps(@Query("access_token") String accessToken);

    class GetCallBackIpsConverter extends JacksonConverter<Void,List<String>> {
        @Override
        public List<String> response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, String.class);
            return mapper.readValue(mapper.readTree(response).path("ip_list").toString(), collectionType);
        }
    }
}
