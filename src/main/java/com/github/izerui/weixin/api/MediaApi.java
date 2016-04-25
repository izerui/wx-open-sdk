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
package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import com.github.izerui.weixin.mappings.News;
import com.github.izerui.weixin.mappings.MaterialStatus;
import com.github.izerui.weixin.mappings.MediaStatus;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by serv on 16/4/25.
 */
public interface MediaApi {

    @Multipart
    @POST("media/upload")
    Call<MediaStatus> upload(@Part List<MultipartBody.Part> media, @Query("type")String type , @Query("access_token")String accessToken);


    @Multipart
    @POST("media/uploadimg")
    @Converter(UploadImgConverter.class)
    Call<String> uploadImg(@Part List<MultipartBody.Part> media,@Query("access_token")String accessToken);

    @POST("material/add_material")
    Call<MaterialStatus> addMaterial(@Body MultipartBody media, @Query("access_token")String accessToken);

    @POST("material/add_news")
    @Converter(AddNewsConverter.class)
    Call<String> addNewses(@Body List<News> newses, @Query("access_token")String accessToken);


    class UploadImgConverter extends JacksonConverter<List<MultipartBody.Part>,String> {
        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            return mapper.readTree(response).path("url").asText();
        }
    }

    class AddNewsConverter extends JacksonConverter<List<News>,String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, List<News> newses) throws IOException {
            Map map = new HashMap();
            map.put("articles",newses);
            return mapper.writeValueAsBytes(map);
        }

        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            JsonNode jsonNode = mapper.readTree(response);
            return jsonNode.path("media_id").asText();
        }
    }
}
