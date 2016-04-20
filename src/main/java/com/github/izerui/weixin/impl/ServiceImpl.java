package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.WxException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Created by serv on 16/4/20.
 */
public class ServiceImpl{

    protected Retrofit retrofit;

    protected String accessToken = null;

    public ServiceImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    protected <T> T execute(Call<T> call){
        try {
            Response<T> response = call.execute();
            if(response.isSuccessful()){
                return response.body();
            }else {
                throw new WxException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new WxException(e.getMessage());
        }
    }

    public String getAccessToken() {
        return accessToken;
    }

    public <T extends ServiceImpl> T setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return (T) this;
    }
}
