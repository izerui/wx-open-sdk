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
package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import com.github.izerui.weixin.mappings.Group;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/19.
 */
public interface GroupApi {

    @GET("groups/get")
    @Converter(GroupsConverter.class)
    Call<List<Group>> groups(@Query("access_token") String accessToken);

    @POST("groups/create")
    @Converter(CreateConverter.class)
    Call<Group> create(@Body String name,@Query("access_token") String accessToken);

    @POST("groups/getid")
    @Converter(GetUserGroupConverter.class)
    Call<Integer> getUserGroup(@Body String openId,@Query("access_token")String accessToken);

    @POST("groups/update")
    @Converter(UpdateGroupConverter.class)
    Call<Status> update(@Body Group group, @Query("access_token")String accessToken);


    class GroupsConverter extends JacksonConverter<Void,List<Group>>{
        @Override
        public List<Group> response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            JsonNode jsonNode = mapper.readTree(response);

            CollectionType collectionType = mapper.getTypeFactory()
                    .constructCollectionType(ArrayList.class, Group.class);

            return mapper.readValue(jsonNode.path("groups").toString(),collectionType);
        }
    }

    class CreateConverter extends JacksonConverter<String,Group>{
        @Override
        public Group response(ObjectMapper mapper, Type type, byte[] bytes) throws IOException {
            JsonNode jsonNode = mapper.readTree(bytes);
            return mapper.readValue(jsonNode.path("group").toString(),Group.class);
        }

        @Override
        public byte[] request(ObjectMapper mapper, Type type, String name) throws IOException {
            return String.format("{\"group\":{\"name\":\"%s\"}}",name).getBytes(CHARSET_UTF8);
        }
    }

    class GetUserGroupConverter extends JacksonConverter<String,Integer> {

        @Override
        public Integer response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            return mapper.readTree(response).path("groupid").asInt();
        }

        @Override
        public byte[] request(ObjectMapper mapper, Type type, String value) throws IOException {
            return String.format("{\"openid\":\"%s\"}",value).getBytes(CHARSET_UTF8);
        }
    }

    class UpdateGroupConverter extends JacksonConverter<Group,String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, Group group) throws IOException {
            return String.format("{\"group\":%s}",mapper.writeValueAsString(group)).getBytes(CHARSET_UTF8);
        }
    }

}
