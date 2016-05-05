package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.Semantic;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/24.
 */
public interface SemanticApi {

    @POST("https://api.weixin.qq.com/semantic/semproxy/search")
    Call<String> search(@Body Semantic semantic, @Query("access_token") java.lang.String accessToken);
}
