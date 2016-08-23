package com.github.izerui.weixin.api;

import com.github.izerui.weixin.mappings.QrCode;
import com.github.izerui.weixin.mappings.Ticket;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by serv on 16/4/24.
 */
public interface QrcodeApi {

    @POST("qrcode/create")
    Call<Ticket> create(@Body QrCode qrCode , @Query("access_token")String accessToken);


}
