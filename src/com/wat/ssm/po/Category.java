package com.wat.ssm.po;

import java.util.Date;

public class Category {
    private Integer id;

    private String name;

    private Integer level;

    private Integer pid;

    private Date categorytime;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCategorytime() {
        return categorytime;
    }

    public void setCategorytime(Date categorytime) {
        this.categorytime = categorytime;
    }
}