/**
 *          你他妈的想干嘛就干嘛公共许可证
 *               第二版，2004年12月
 *
 * 版权所有(C) 2004 serv<liuyuhua69@gmail.com>
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

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class Menu implements Serializable {

    private List<Button> button;

    @JsonProperty("menuid")
    private Integer menuId;

    private Matchrule matchrule;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }


    @Override
    public String toString() {
        return String.format("Menu[menuId=%s,button=%s,matchrule=%s]",menuId,button,matchrule);
    }

    public static class Matchrule{

        @JsonProperty("group_id")
        private Integer groupId;

        @JsonProperty("sex")
        private Integer sex;

        @JsonProperty("country")
        private String country;

        @JsonProperty("province")
        private String province;

        @JsonProperty("city")
        private String city;

        @JsonProperty("client_platform_type")
        private String clientPlatformType;


        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getClientPlatformType() {
            return clientPlatformType;
        }

        public void setClientPlatformType(String clientPlatformType) {
            this.clientPlatformType = clientPlatformType;
        }

        @Override
        public String toString() {
            return String.format("Matchrule[groupId=%s,sex=%s,country=%s,province=%s,city=%s,clientPlatformType=%s]",groupId,sex,country,province,city,clientPlatformType);
        }
    }

}
