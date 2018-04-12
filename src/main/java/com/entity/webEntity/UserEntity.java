package com.entity.webEntity;

import com.alibaba.fastjson.JSONObject;

/**
 * 提供接口的类
 */
public class UserEntity {

    private int id;

    private String username;

    private int status;

    private int sex;

    private String photo;

    private int age;

    public UserEntity (int id, String username, int status, int sex, String photo, int age) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.sex = sex;
        this.photo = photo;
        this.age = age;
    }

    public UserEntity () {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
