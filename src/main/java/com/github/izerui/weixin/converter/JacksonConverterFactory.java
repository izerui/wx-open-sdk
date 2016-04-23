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
package com.github.izerui.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * A {@linkplain retrofit2.Converter.Factory converter} which uses Jackson.
 * <p>
 * Because Jackson is so flexible in the types it supports, this converter assumes that it can
 * handle all types. If you are mixing JSON serialization with something else (such as protocol
 * buffers), you must {@linkplain Retrofit.Builder#addConverterFactory(retrofit2.Converter.Factory) add this
 * instance} last to allow the other converters a chance to see their types.
 */
public final class JacksonConverterFactory extends retrofit2.Converter.Factory {
    /** Create an instance using a default {@link ObjectMapper} instance for conversion. */
    public static JacksonConverterFactory create() {
        return create(new ObjectMapper());
    }

    /** Create an instance using {@code mapper} for conversion. */
    public static JacksonConverterFactory create(ObjectMapper mapper) {
        return new JacksonConverterFactory(mapper);
    }

    private final ObjectMapper mapper;

    private JacksonConverterFactory(ObjectMapper mapper) {
        if (mapper == null) throw new NullPointerException("mapper == null");
        this.mapper = mapper;
    }

    @Override
    public retrofit2.Converter responseBodyConverter(Type type, Annotation[] annotations,
                                                     Retrofit retrofit) {
        return new JacksonResponseBodyConverter<>(type, annotations,mapper);
    }

    @Override
    public retrofit2.Converter requestBodyConverter(Type type,
                                                    Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JacksonRequestBodyConverter<>(type, methodAnnotations,mapper);
    }

    private JacksonConverter createConverter(Annotation[] annotations){
        for (Annotation annotation : annotations) {
            if (annotation instanceof Converter) {
                try {
                    return ((Converter) annotation).value().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return new JacksonConverter();
    }

    private class JacksonRequestBodyConverter<T> implements retrofit2.Converter<T, RequestBody> {
        protected final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

        protected final Type type;
        private final Annotation[] methodAnnotations;
        protected final ObjectMapper mapper;

        private JacksonRequestBodyConverter(Type type, Annotation[] methodAnnotations, ObjectMapper mapper) {
            this.type = type;
            this.methodAnnotations = methodAnnotations;
            this.mapper = mapper;
        }

        @Override
        public final RequestBody convert(T value) throws IOException {

            JacksonConverter converter = createConverter(methodAnnotations);

            byte[] bytes = converter.request(mapper,type,value);

            return RequestBody.create(MEDIA_TYPE, bytes);
        }

    }

    private class JacksonResponseBodyConverter<T> implements retrofit2.Converter<ResponseBody, T> {
        private final Type type;
        private final Annotation[] annotations;
        private final ObjectMapper mapper;

        private JacksonResponseBodyConverter(Type type, Annotation[] annotations, ObjectMapper mapper) {
            this.type = type;
            this.annotations = annotations;
            this.mapper = mapper;
        }

        @Override
        public final T convert(ResponseBody value) throws IOException {

            JacksonConverter converter = createConverter(annotations);

            byte[] bytes = value.bytes();
            converter.preConvertResponse(mapper,type,bytes);
            return (T) converter.response(mapper,type,bytes);
        }

    }

}
