package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
public class UserGroup implements Serializable {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public UserGroup() {
    }

    public UserGroup(String openId, Integer toGroupId) {
        this.openId = openId;
        this.toGroupId = toGroupId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Integer toGroupId) {
        this.toGroupId = toGroupId;
    }
}
