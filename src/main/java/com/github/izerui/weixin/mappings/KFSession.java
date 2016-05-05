package com.github.izerui.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by rocky on 2016/5/4.
 */
public class KFSession implements Serializable {

    @JsonProperty(value = "kf_account")
    private String KFAccount;

    @JsonProperty(value = "nickname")
    private String nickName;

    @JsonProperty(value = "password")
    private String passWord;

    public String getKFAccount() {
        return KFAccount;
    }

    public void setKFAccount(String KFAccount) {
        this.KFAccount = KFAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
