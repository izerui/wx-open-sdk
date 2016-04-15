package com.github.izerui.weixin;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by serv on 16/4/15.
 */
public class WxApiStores {

    public static ApiStores api(){
        return api(null);
    }

    public static ApiStores api(Retrofit retrofit){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.weixin.qq.com/cgi-bin/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiStores.class);
    }
}
