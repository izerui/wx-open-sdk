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
package tobeused.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/6/10.
 */
public class PoiPageInfo implements Serializable {

    @JsonProperty("errcode")
    private String errCode ;

    @JsonProperty("errmsg")
    private String errMsg ;

    @JsonProperty("business_list")
    private List<PoiInfo> businessList ;

    @JsonProperty("total_count")
    private String totalCount ;


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<PoiInfo> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<PoiInfo> businessList) {
        this.businessList = businessList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
