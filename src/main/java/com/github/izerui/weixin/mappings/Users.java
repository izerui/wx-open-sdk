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
