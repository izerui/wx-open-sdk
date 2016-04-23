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
package tobeused.vo.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/7/1.
 */
public class CardList implements Serializable {

    /**
     * 错误码，0为正常。
     */
    @JsonProperty("errcode")
    private String errCode ;

    /**
     * 错误信息。
     */
    @JsonProperty("errmsg")
    private String errMsg ;

    /**
     * 卡券ID列表。
     */
    @JsonProperty("card_id_list")
    private List<String> cardIdList ;

    /**
     * 该商户名下卡券ID总数。
     */
    @JsonProperty("total_num")
    private String totalNum ;

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

    public List<String> getCardIdList() {
        return cardIdList;
    }

    public void setCardIdList(List<String> cardIdList) {
        this.cardIdList = cardIdList;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }
}
