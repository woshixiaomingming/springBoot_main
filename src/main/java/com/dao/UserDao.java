package com.dao;

import com.model.User;
import com.util.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends Data {

    public void insertUser () {
        System.out.println(insert("insert user set name = ?", new Object[]{"xmmmmmmmm"}));
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.insertUser();
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User findUserById (int id) {
        String sql = "select * from user where id = ?";
        return GetOne(sql, new Object[]{id}, User.class);
    }

    public User findByUsernameAndPwd (String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return getOne(sql, new Object[]{username, password}, User.class);
    }
}
