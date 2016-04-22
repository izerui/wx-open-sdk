/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
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
