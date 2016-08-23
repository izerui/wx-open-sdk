
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
