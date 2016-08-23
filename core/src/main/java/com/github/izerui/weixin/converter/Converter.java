package com.github.izerui.weixin.converter;

import java.lang.annotation.*;

/**
 * Created by serv on 16/4/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Converter {
    Class<? extends JacksonConverter> value();
}
