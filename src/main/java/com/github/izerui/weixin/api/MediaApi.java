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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import com.github.izerui.weixin.mappings.MediaStatus;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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


    class UploadImgConverter extends JacksonConverter<List<MultipartBody.Part>,String> {
        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            return mapper.readTree(response).path("url").asText();
        }
    }
}
