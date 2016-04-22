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
package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by serv on 16/4/22.
 */
public class StringRequestConverter extends JacksonRequestBodyConverter<String> {

    public StringRequestConverter(Type type, ObjectMapper mapper) {
        super(type, mapper);
    }

    @Override
    public RequestBody convert(String value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.getBytes("UTF-8"));
    }
}
