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
package tobeused.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 2015/5/14.
 */
public class DeviceApplyId implements Serializable {

    @JsonProperty("apply_id")
    private String applyId;

    @JsonProperty("device_identifiers")
    private List<Identifiers> identifierses;

    @JsonProperty("audit_status")
    private String auditStatus;

    @JsonProperty("audit_comment")
    private String auditComment;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public List<Identifiers> getIdentifierses() {
        return identifierses;
    }

    public void setIdentifierses(List<Identifiers> identifierses) {
        this.identifierses = identifierses;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }
}
