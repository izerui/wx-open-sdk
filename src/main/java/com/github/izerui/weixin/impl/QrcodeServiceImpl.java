package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.QrcodeService;
import com.github.izerui.weixin.api.QrcodeApi;
import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;
import retrofit2.Retrofit;

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
}
