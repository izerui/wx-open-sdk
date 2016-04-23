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

import com.github.izerui.weixin.mappings.AccessToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/19.
 */
public interface AccessTokenApi {
    @GET("token")
    Call<AccessToken> getToken(@Query("grant_type") String grantType, @Query("appid") String appId, @Query("secret") String appSecret);

}
