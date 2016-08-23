package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/24.
 */
public interface ShortUrlApi {

    @POST("shorturl")
    @Converter(ShortUrlConverter.class)
    Call<String> shortUrl(@Body String longUrl,@Query("access_token")String accessToken);

    class ShortUrlConverter extends JacksonConverter<String,String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, String longUrl) throws IOException {
            return String.format("{\"action\":\"long2short\",\"long_url”:”%s”}",longUrl).getBytes(CHARSET_UTF8);
        }

        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            JsonNode jsonNode = mapper.readTree(response);
            return jsonNode.path("short_url").asText();
        }
    }
}
