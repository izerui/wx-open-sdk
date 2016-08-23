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

    @POST("groups/update")
    @Converter(UpdateGroupConverter.class)
    Call<Status> update(@Body Group group, @Query("access_token") String accessToken);

    @POST("groups/delete")
    @Converter(DeleteConverter.class)
    Call<Status> delete(@Body Integer groupId,@Query("access_token") String accessToken);


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

    class UpdateGroupConverter extends JacksonConverter<Group,String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, Group group) throws IOException {
            return String.format("{\"group\":%s}",mapper.writeValueAsString(group)).getBytes(CHARSET_UTF8);
        }
    }

    class DeleteConverter extends JacksonConverter<Integer,Status> {

        @Override
        public byte[] request(ObjectMapper mapper, Type type, Integer groupId) throws IOException {
            return String.format("{\"group\":{\"id\":%s}}",groupId).getBytes(CHARSET_UTF8);
        }
    }
}
