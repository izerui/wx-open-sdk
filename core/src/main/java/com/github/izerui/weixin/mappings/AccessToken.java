
package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 16/4/15.
 */
public class AccessToken implements Serializable {

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
