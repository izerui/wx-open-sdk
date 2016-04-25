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
package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.MediaService;
import com.github.izerui.weixin.api.MediaApi;
import com.github.izerui.weixin.mappings.Media;
import com.github.izerui.weixin.mappings.MediaStatus;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

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
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("filelength",String.valueOf(media.getData().length));
        builder.addFormDataPart("media",media.getFileName(),RequestBody.create(MediaType.parse("application/octet-stream"), media.getData()));
        return execute(api().upload(builder.build().parts(),media.getType().name(),accessToken));
    }
}
