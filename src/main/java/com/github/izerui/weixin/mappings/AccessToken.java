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
}
