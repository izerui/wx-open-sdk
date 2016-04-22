/**
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
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
