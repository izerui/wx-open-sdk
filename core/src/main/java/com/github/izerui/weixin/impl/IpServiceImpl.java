
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
