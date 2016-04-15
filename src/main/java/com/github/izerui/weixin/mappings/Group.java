package com.github.izerui.weixin.mappings;

import java.io.Serializable;

/**
 * Created by serv on 2014/7/28.
 */
public class Group implements Serializable{
    private int id;
    private String name;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
