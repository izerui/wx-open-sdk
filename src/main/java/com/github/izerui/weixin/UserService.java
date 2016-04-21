package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.Users;

/**
 * Created by serv on 16/4/21.
 */
public interface UserService {

    Users get(String nextOpenId);
}
