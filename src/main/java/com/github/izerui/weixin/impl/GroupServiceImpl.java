package com.github.izerui.weixin.impl;

import com.github.izerui.weixin.GroupService;
import com.github.izerui.weixin.api.GroupApi;
import com.github.izerui.weixin.mappings.Group;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class GroupServiceImpl extends ServiceImpl implements GroupService {

    public GroupServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public List<Group> groups() {
        GroupApi api = retrofit.create(GroupApi.class);
        return execute(api.groups(accessToken));
    }
}
