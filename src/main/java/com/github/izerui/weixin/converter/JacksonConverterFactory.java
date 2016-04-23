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
import com.github.izerui.weixin.support.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
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

    for (Annotation annotation : annotations){
      if(annotation instanceof Converter){
        try {
          Constructor constructor = ((Converter) annotation).response().getConstructor(Type.class,ObjectMapper.class);
          return (retrofit2.Converter) constructor.newInstance(type,mapper);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }

    return new JacksonResponseBodyConverter<>(type,mapper);
  }

  @Override
  public retrofit2.Converter requestBodyConverter(Type type,
                                                  Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

    for (Annotation annotation : methodAnnotations){
      if(annotation instanceof Converter){
        try {
          Constructor constructor = ((Converter) annotation).request().getConstructor(Type.class,ObjectMapper.class);
          return (retrofit2.Converter) constructor.newInstance(type,mapper);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }

    return new JacksonRequestBodyConverter<>(type,mapper);
  }
}
