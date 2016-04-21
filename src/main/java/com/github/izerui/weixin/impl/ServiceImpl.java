package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.WxException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Created by serv on 16/4/20.
 */
public abstract class ServiceImpl<T>{

    protected Retrofit retrofit;

    protected String accessToken = null;

    public ServiceImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * 执行retrofit请求
     * @param call 请求对象持有者
     * @param <U>  response 类对象
     * @return
     */
    protected <U> U execute(Call<U> call){
        try {
            Response<U> response = call.execute();
            if(response.isSuccessful()){
                return response.body();
            }else {
                throw new WxException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new WxException(e.getMessage());
        }
    }

    /**
     * 获取当前请求的accessToken
     * @return
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 放入accessToken
     * @param accessToken
     * @param <U>
     * @return
     */
    public <U extends ServiceImpl> U setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return (U) this;
    }

    /**
     * 获取retrofit的api接口类对象
     * @return 创建的api对象
     */
    protected T api(){
        Class<T> apiClass = getApiClass();
        if(apiClass==null){
            throw new WxException("api class must not be null!");
        }
        return retrofit.create(apiClass);
    }

    /**
     * serviceImpl用来创建请求的接口类
     * @return
     */
    protected abstract Class<T> getApiClass();
}
