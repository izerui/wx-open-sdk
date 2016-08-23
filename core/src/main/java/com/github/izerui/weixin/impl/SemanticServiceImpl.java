
package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.SemanticService;
import com.github.izerui.weixin.api.SemanticApi;
import com.github.izerui.weixin.mappings.Semantic;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/24.
 */
public class SemanticServiceImpl extends ServiceImpl<SemanticApi> implements SemanticService {

    public SemanticServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<SemanticApi> getApiClass() {
        return SemanticApi.class;
    }

    @Override
    public String search(Semantic semantic) {
        return execute(api().search(semantic,accessToken));
    }
}
