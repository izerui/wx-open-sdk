package com.github.izerui.weixin;

import com.github.izerui.weixin.converter.JacksonConverterFactory;
import com.github.izerui.weixin.impl.*;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/15.
 */
public class WxEngine {

    private Retrofit retrofit;

    private TokenService tokenService;
    private MenuService menuService;
    private GroupService groupService;
    private MessageService messageService;
    private UserService userService;
    private CommonService commonService;

    public WxEngine() {
        retrofit = builder().build();
        init();
    }

    public WxEngine(OkHttpClient client){
        retrofit = builder().client(client).build();
        init();
    }

    private void init(){
        tokenService = new TokenServiceImpl(retrofit);
        menuService = new MenuServiceImpl(retrofit);
        groupService = new GroupServiceImpl(retrofit);
        messageService = new MessageServiceImpl(retrofit);
        userService = new UserServiceImpl(retrofit);
        commonService = new CommonServiceImpl(retrofit);
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
        return ((ServiceImpl<?>)menuService).setAccessToken(accessToken);
    }

    public GroupService getGroupService(String accessToken){
        return ((ServiceImpl<?>)groupService).setAccessToken(accessToken);
    }

    public MessageService getMessageService(String accessToken){
        return ((ServiceImpl<?>)messageService).setAccessToken(accessToken);
    }

    public UserService getUserService(String accessToken){
        return ((ServiceImpl<?>)userService).setAccessToken(accessToken);
    }

    public CommonService getCommonService(String accessToken){
        return ((ServiceImpl<?>)commonService).setAccessToken(accessToken);
    }
}
