package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.Message;
import com.github.izerui.weixin.mappings.Status;

/**
 * Created by serv on 16/4/21.
 */
public interface MessageService {

    Status send(Message message);
}
