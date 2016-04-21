package com.github.izerui.weixin;

import com.github.izerui.weixin.mappings.Button;
import com.github.izerui.weixin.mappings.Menu;
import com.github.izerui.weixin.mappings.Status;

import java.util.List;

/**
 * Created by serv on 16/4/20.
 */
public interface MenuService{

    Status create(List<Button> buttons);

    List<Menu> get();

    Status delete();
}
