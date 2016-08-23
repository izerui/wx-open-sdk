
package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.ShortUrlService;
import com.github.izerui.weixin.api.ShortUrlApi;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlServiceImpl extends ServiceImpl<ShortUrlApi> implements ShortUrlService {

    public ShortUrlServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<ShortUrlApi> getApiClass() {
        return ShortUrlApi.class;
    }

    @Override
    public String shortUrl(String longUrl) {
        return execute(api().shortUrl(longUrl,accessToken));
    }
}
