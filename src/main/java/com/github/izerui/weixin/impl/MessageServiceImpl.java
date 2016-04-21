package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.MessageService;
import com.github.izerui.weixin.api.MessageApi;
import com.github.izerui.weixin.mappings.Status;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/21.
 */
public class MessageServiceImpl extends ServiceImpl<MessageApi> implements MessageService {

    public MessageServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<MessageApi> getApiClass() {
        return MessageApi.class;
    }

    @Override
    public Status send(String message) {
        return execute(api().send(message,accessToken));
    }
}
