package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
public class ArrayUser implements Serializable {

    @JsonProperty("openid_list")
    private String[] openidList;

    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public ArrayUser(Integer toGroupId, String... openidList) {
        this.toGroupId = toGroupId;
        this.openidList = openidList;
    }

    public String[] getOpenidList() {
        return openidList;
    }

    public void setOpenidList(String[] openidList) {
        this.openidList = openidList;
    }

    public Integer getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Integer toGroupId) {
        this.toGroupId = toGroupId;
    }
}
