package com.github.izerui.weixin.api;

import com.github.izerui.weixin.converter.StringRequestConverter;
import com.github.izerui.weixin.converter.StringResponseConverter;
import com.github.izerui.weixin.support.Converter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by serv on 16/4/22.
 */
public interface CommonApi {


    @GET
    @Converter(request = StringRequestConverter.class,response = StringResponseConverter.class)
    Call<String> get(@Url String url);

    @POST
    @Converter(request = StringRequestConverter.class,response = StringResponseConverter.class)
    Call<String> post(@Url String url , @Body String json);
}
