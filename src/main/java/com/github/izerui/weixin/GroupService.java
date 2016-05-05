package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.Group;
import com.github.izerui.weixin.mappings.Status;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public interface GroupService {
    List<Group> groups();
    Group create(String name);
    Status update(Group group);
    Status delete(Integer groupId);
}
