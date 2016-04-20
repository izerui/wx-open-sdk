package com.github.izerui.weixin.support;

import com.github.izerui.weixin.converter.JacksonResponseBodyConverter;

import java.lang.annotation.*;

/**
 * Created by serv on 16/4/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ResponseConverter {
    Class<? extends JacksonResponseBodyConverter> value();
}
