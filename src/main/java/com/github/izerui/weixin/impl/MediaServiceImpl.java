/**
 * 你他妈的想干嘛就干嘛公共许可证
 * 第二版，2004年12月
 * <p/>
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
 * <p/>
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 * <p/>
 * 你他妈的想干嘛就干嘛公共许可证
 * 复制、发布和修改条款
 * <p/>
 * 0. 你只要他妈的想干嘛就干嘛好了。
 */
package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.MediaService;
import com.github.izerui.weixin.api.MediaApi;
import com.github.izerui.weixin.mappings.MaterialStatus;
import com.github.izerui.weixin.mappings.Media;
import com.github.izerui.weixin.mappings.MediaStatus;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by serv on 16/4/25.
 */
public class MediaServiceImpl extends ServiceImpl<MediaApi> implements MediaService {

    public MediaServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<MediaApi> getApiClass() {
        return MediaApi.class;
    }

    @Override
    public MediaStatus upload(Media media) {
        return execute(api().upload(toMedia(media), media.getType().name(), accessToken));
    }

    @Override
    public URL url(String mediaId) {
        try {
            return retrofit.baseUrl().resolve("media/get").newBuilder().addQueryParameter("access_token", accessToken)
                    .addQueryParameter("media_id", URLEncoder.encode(mediaId, "UTF-8")).build().url();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String uploadImg(Media media) {
        return execute(api().uploadImg(toMedia(media), accessToken));
    }

    private List<MultipartBody.Part> toMedia(Media media) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("media", media.getFileName(), RequestBody.create(MediaType.parse("application/octet-stream"), media.getData()))
                .addPart(RequestBody.create(MediaType.parse("text/plain"), String.valueOf(media.getData().length)));
        return builder.build().parts();
    }

    @Override
    public MaterialStatus addMaterial(Media media) {

        MultipartBody.Builder builder = new MultipartBody.Builder();

        builder.addFormDataPart("media", media.getFileName(), RequestBody.create(MediaType.parse("application/octet-stream"), media.getData()))
                .addPart(RequestBody.create(MediaType.parse("text/plain"), String.valueOf(media.getData().length)));

        if (media.getType().equals(Media.Type.video)) {
            builder.addFormDataPart("description",
                    String.format("{\"title\":\"%s\",\"introduction\":\"%s\"}",
                            media.getTitle(), media.getIntroduction()));
        }

        builder.setType(MultipartBody.FORM);

        return execute(api().addMaterial(builder.build(), accessToken));
    }

}
