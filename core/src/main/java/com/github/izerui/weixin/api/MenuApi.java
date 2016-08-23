package com.github.izerui.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.izerui.weixin.converter.Converter;
import com.github.izerui.weixin.converter.JacksonConverter;
import com.github.izerui.weixin.mappings.Button;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by serv on 16/4/19.
 */
public interface MenuApi {

    @POST("menu/create")
    @Converter(CreateConverter.class)
    Call<Status> create(@Body List<Button> buttons, @Query("access_token")String accessToken);

    @GET("menu/get")
    @Converter(GetConverter.class)
    Call<List<Menu>> get(@Query("access_token")String accessToken);

    @GET("menu/delete")
    Call<Status> delete(@Query("access_token")String accessToken);



    class CreateConverter extends JacksonConverter<List<Button>,Status>{
        @Override
        public byte[] request(ObjectMapper mapper, Type type, List<Button> buttons) throws IOException {
            Map map = new HashMap();
            map.put("button", buttons);
            return mapper.writeValueAsBytes(map);
        }
    }
    class GetConverter extends JacksonConverter<Void,List<Menu>>{
        @Override
        public List<Menu> response(ObjectMapper mapper, Type type, byte[] bytes) throws IOException {
            List<Menu> menus = new ArrayList<>();
            JsonNode jsonNode = mapper.readTree(bytes);
            Menu defaultMenu = mapper.readValue(jsonNode.path("menu").toString(), Menu.class);
            menus.add(defaultMenu);

            if(jsonNode.has("conditionalmenu")){
                CollectionType collectionType = mapper.getTypeFactory()
                        .constructCollectionType(ArrayList.class, Menu.class);
                List<Menu> conditionalMenus = mapper.readValue(jsonNode.path("conditionalmenu").toString(),collectionType);

                menus.addAll(conditionalMenus);
            }

            return menus;
        }
    }
}
