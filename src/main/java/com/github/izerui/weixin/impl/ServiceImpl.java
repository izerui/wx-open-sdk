/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
 */
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
                throw new WxException(-100,response.errorBody().string());
            }
        } catch (IOException e) {
            throw new WxException(-101,e.getMessage());
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
            throw new WxException(-102,"api class must not be null!");
        }
        return retrofit.create(apiClass);
    }

    /**
     * serviceImpl用来创建请求的接口类
     * @return
     */
    protected abstract Class<T> getApiClass();
}
