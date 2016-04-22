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

/**
 * Created by serv on 2015/5/14.
 */
public class DeviceInfo extends Identifiers {

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("page_ids")
    private String page_ids;

    @JsonProperty("status")
    private String status;

    @JsonProperty("poiId")
    private String poiId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPage_ids() {
        return page_ids;
    }

    public void setPage_ids(String page_ids) {
        this.page_ids = page_ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
