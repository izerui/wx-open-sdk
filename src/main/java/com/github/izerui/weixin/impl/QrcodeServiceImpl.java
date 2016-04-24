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

import com.github.izerui.weixin.QrcodeService;
import com.github.izerui.weixin.api.QrcodeApi;
import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;
import retrofit2.Retrofit;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by serv on 16/4/24.
 */
public class QrcodeServiceImpl extends ServiceImpl<QrcodeApi> implements QrcodeService{

    public QrcodeServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<QrcodeApi> getApiClass() {
        return QrcodeApi.class;
    }

    @Override
    public Ticket create(QrCode qrCode) {
        return execute(api().create(qrCode,accessToken));
    }

    @Override
    public URL url(String ticket) {
        try {
            return new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ URLEncoder.encode(ticket,"UTF-8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
