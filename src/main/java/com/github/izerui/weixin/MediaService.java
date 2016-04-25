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
package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.MaterialStatus;
import com.github.izerui.weixin.mappings.Media;
import com.github.izerui.weixin.mappings.MediaStatus;

import java.net.URL;

/**
 * Created by serv on 16/4/25.
 */
public interface MediaService {

    MediaStatus upload(Media media);

    URL url(String mediaId);

    /**
     * 上传图文消息内的图片获取URL
     *
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     *
     * @param media
     * @return
     */
    String uploadImg(Media media);

    MaterialStatus addMaterial(Media media);
}
