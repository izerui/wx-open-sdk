package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by serv on 16/4/15.
 */
public class AccessToken extends ErrorBody{

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
