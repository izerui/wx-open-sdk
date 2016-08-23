
package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.*;

/**
 * Created by serv on 16/4/21.
 */
public interface UserService {

    Users getUsers(String nextOpenId);

    Integer getGroup(String openId);

    Status move(OneUser oneUser);

    Status move(ArrayUser arrayUser);

    Status update(UserRemark userRemark);

    UserInfo userInfo(String openId);

}
