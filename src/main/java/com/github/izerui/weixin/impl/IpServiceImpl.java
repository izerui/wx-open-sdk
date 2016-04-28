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

import com.github.izerui.weixin.IpService;
import com.github.izerui.weixin.api.IpApi;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by serv on 16/4/28.
 */
public class IpServiceImpl extends ServiceImpl<IpApi> implements IpService {

    public IpServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<IpApi> getApiClass() {
        return IpApi.class;
    }

    @Override
    public List<String> getCallBackIps() {
        return execute(api().getCallBackIps(accessToken));
    }
}
