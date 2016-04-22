/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 桑·奥塞瓦<sam@hocevar.net>
 *
 * 任何人都有复制与发布本协议的原始或修改过的版本的权利。
 * 若本协议被修改，须修改协议名称。
 *
 *          你他妈的想干嘛就干嘛公共许可证
 *              复制、发布和修改条款
 *
 *  0. 你只要他妈的想干嘛就干嘛好了。
 */
package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by serv on 16/4/15.
 */
public class AccessToken extends Status {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    //获取token时的毫秒级
    private Long tokenTimeMillis = System.currentTimeMillis();

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long expiresInSeconds(){
        return expiresIn - ((System.currentTimeMillis() - tokenTimeMillis)/1000);
    }

    public Long expiresInMinites(){
        return expiresInSeconds()/60;
    }

    @Override
    public String toString() {
        return String.format("AccessToken[accessToken=%s,expiresIn=%s]",accessToken,expiresIn);
    }
}
