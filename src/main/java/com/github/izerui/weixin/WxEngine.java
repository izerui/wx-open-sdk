package com.github.izerui.weixin;

import com.github.izerui.weixin.converter.JacksonConverterFactory;
import com.github.izerui.weixin.impl.MenuServiceImpl;
import com.github.izerui.weixin.impl.ServiceImpl;
import com.github.izerui.weixin.impl.TokenServiceImpl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/15.
 */
public class WxEngine {

    private Retrofit retrofit;

    private TokenService tokenService;
    private MenuService menuService;

    public WxEngine() {
        retrofit = builder().build();
        init();
    }

    public WxEngine(OkHttpClient client){
        retrofit = builder().client(client).build();
        init();
    }

    private void init(){
        //TODO 更多service
        tokenService = new TokenServiceImpl(retrofit);
        menuService = new MenuServiceImpl(retrofit);
    }

    protected Retrofit.Builder builder(){
        return new Retrofit.Builder()
                .baseUrl("https://api.weixin.qq.com/cgi-bin/")
                .addConverterFactory(JacksonConverterFactory.create());
    }

    public TokenService getTokenService(){
        return tokenService;
    }

    public MenuService getMenuService(String accessToken){
        return ((MenuServiceImpl)menuService).setAccessToken(accessToken);
    }
}
