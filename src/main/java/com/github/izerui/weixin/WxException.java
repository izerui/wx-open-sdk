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
package com.github.izerui.weixin;

/**
 * Created by serv on 16/4/20.
 */
public class WxException extends RuntimeException {

    private int errcode;

    public WxException(int errcode) {
        this.errcode = errcode;
    }

    public WxException(int errcode , String message) {
        super(message);
        this.errcode = errcode;
    }

    public WxException(int errcode , String message, Throwable cause) {
        super(message, cause);
        this.errcode = errcode;
    }

    public int getErrcode() {
        return errcode;
    }

    @Override
    public String toString() {
        return String.format("WxException[errcode=%s,errmsg=%s]",errcode,getMessage());
    }
}
