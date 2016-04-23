package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
public class UserRemark implements Serializable{

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("remark")
    private String remark;

    public UserRemark(String openId, String remark) {
        this.openId = openId;
        this.remark = remark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
