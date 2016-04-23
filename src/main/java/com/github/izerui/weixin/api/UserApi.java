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

import com.github.izerui.weixin.converter.GetUserGroupRequestConverter;
import com.github.izerui.weixin.mappings.Users;
import com.github.izerui.weixin.support.Converter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/21.
 */
public interface UserApi {

    @GET("user/get")
    Call<Users> get(@Query("next_openid")String nextOpenId, @Query("access_token")String accessToken);

    @POST("groups/getid")
    @Converter(request = GetUserGroupRequestConverter.class)
    Call<Integer> getUserGroup(@Body String openId,@Query("access_token")String accessToken);
}
