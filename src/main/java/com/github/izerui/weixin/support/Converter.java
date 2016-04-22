package com.github.izerui.weixin.support;

import com.github.izerui.weixin.converter.JacksonRequestBodyConverter;
import com.github.izerui.weixin.converter.JacksonResponseBodyConverter;

import java.lang.annotation.*;

/**
 * Created by serv on 16/4/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Converter {
    Class<? extends JacksonResponseBodyConverter> response() default JacksonResponseBodyConverter.class;
    Class<? extends JacksonRequestBodyConverter> request() default JacksonRequestBodyConverter.class;
}
