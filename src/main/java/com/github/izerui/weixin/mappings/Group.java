package com.github.izerui.weixin.mappings;

/**
 * Created by serv on 16/4/16.
 */
public class Group {

    private Integer id;
    private String name;
    private Integer count;

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
        return String.format("{id:%s name:%s count:%s}",id,name,count);
    }
}
