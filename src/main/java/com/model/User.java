package com.model;

import com.util.Bean;

import java.sql.Timestamp;


public class User extends Bean {

    private int id;

    private String username;

    private Timestamp registerTime;

    private String password;

    private Timestamp lastLoginTime;

    /**
     * 性别 0---男，1---女，2-----人妖
     */
    private int sex;

    private String photo;

    private String loginIp;

    private boolean isDelete;

    /**
     * 状态 0---正常，1---冻结
     */
    private int status;

    private int age;

    public User (String username, Timestamp registerTime, String password, Timestamp lastLoginTime, int sex, String photo, String loginIp, boolean isDelete, int status, int age) {
        this.username = username;
        this.registerTime = registerTime;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
        this.sex = sex;
        this.photo = photo;
        this.loginIp = loginIp;
        this.isDelete = isDelete;
        this.status = status;
        this.age = age;
    }

    public User () {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", registerTime=" + registerTime +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", sex=" + sex +
                ", photo='" + photo + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", isDelete=" + isDelete +
                ", status=" + status +
                ", age=" + age +
                '}';
    }
}
