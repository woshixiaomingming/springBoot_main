package com.model;

public class Meau {

    private int id;

    /**
     * 菜单的名
     */
    private String name;

    /**
     * 父级菜单id
     */
    private int meauId;

    /**
     * 描述
     */
    private String desc;

    /**
     * 返回页面的路径
     */
    private String path;

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

    public int getMeauId() {
        return meauId;
    }

    public void setMeauId(int meauId) {
        this.meauId = meauId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
