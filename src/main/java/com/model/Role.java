package com.model;

import java.sql.Timestamp;

public class Role {

    /**
     * 主键id
     */
    private int id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 是否删除
     */
    private boolean isDelete;

    /**
     * 父类的角色id
     */
    private int roleId;

    /**
     * 描述
     */
    private String des;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
