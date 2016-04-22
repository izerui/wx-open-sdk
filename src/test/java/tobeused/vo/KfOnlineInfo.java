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
package tobeused.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by serv on 2014/11/20.
 */
public class KfOnlineInfo implements Serializable {
    @JsonProperty("kf_account")
    private String kfAccount;
    /**
     * 客服在线状态 1：pc在线，2：手机在线
     * 若pc和手机同时在线则为 1+2=3
     */
    @JsonProperty("status")
    private int status;

    @JsonProperty("kf_id")
    private String kfId;

    @JsonProperty("auto_accept")
    private int autoAccept;

    @JsonProperty("accepted_case")
    private int acceptedCase;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public int getAutoAccept() {
        return autoAccept;
    }

    public void setAutoAccept(int autoAccept) {
        this.autoAccept = autoAccept;
    }

    public int getAcceptedCase() {
        return acceptedCase;
    }

    public void setAcceptedCase(int acceptedCase) {
        this.acceptedCase = acceptedCase;
    }
}
