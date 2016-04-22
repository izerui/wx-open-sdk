package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.CommonService;
import com.github.izerui.weixin.api.CommonApi;
import retrofit2.Retrofit;

import java.util.Map;

/**
 * Created by serv on 16/4/22.
 */
public class CommonServiceImpl extends ServiceImpl<CommonApi> implements CommonService {

    public CommonServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public String get(String url) {
        return execute(api().get(url));
    }

    @Override
    public String post(String url, String json) {
        return execute(api().post(url,json));
    }

    @Override
    protected Class<CommonApi> getApiClass() {
        return CommonApi.class;
    }
}
