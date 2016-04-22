/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
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
