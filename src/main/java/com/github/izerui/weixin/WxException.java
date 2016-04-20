package com.github.izerui.weixin;

/**
 * Created by serv on 16/4/20.
 */
public class WxException extends RuntimeException {

    public WxException() {
        super();
    }

    public WxException(String message) {
        super(message);
    }

    public WxException(String message, Throwable cause) {
        super(message, cause);
    }
}
