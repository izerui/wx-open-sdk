package com.github.izerui.weixin.enumeration;

import com.github.izerui.weixin.converter.JacksonRequestBodyConverter;

import java.lang.annotation.*;

/**
 * Created by serv on 16/4/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestConverter {
    Class<? extends JacksonRequestBodyConverter> value();
}
