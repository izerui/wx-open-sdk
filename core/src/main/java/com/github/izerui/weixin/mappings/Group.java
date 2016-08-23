
package com.github.izerui.weixin.mappings;

import java.io.Serializable;

/**
 * Created by serv on 16/4/16.
 */
public class Group implements Serializable{

    private Integer id;
    private String name;
    private Integer count;

    public Group() {
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Group[id=%s,name=%s,count=%s]",id,name,count);
    }
}
