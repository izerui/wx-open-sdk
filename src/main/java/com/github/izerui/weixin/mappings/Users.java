
package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class Users {
    private Integer total;
    private Integer count;

    @JsonProperty("next_openid")
    private String nextOpenId;

    private Data data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Users[total=%s,count=%s,nextOpenId=%s,data=%s]",total,count,nextOpenId,data);
    }

    public static class Data{

        @JsonProperty("openid")
        private List<String> openId;

        public List<String> getOpenId() {
            return openId;
        }

        public void setOpenId(List<String> openId) {
            this.openId = openId;
        }

        @Override
        public String toString() {
            return "Data[openId="+openId.toString()+"]";
        }
    }

}
