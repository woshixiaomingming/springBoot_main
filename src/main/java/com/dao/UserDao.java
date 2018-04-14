package com.dao;

import com.model.User;
import com.util.Data;
import com.util.PhotoInfoUtil;
import com.util.TimeUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends Data {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User findUserById (int id) {
        String sql = "select * from user where id = ? and isDelete = false";
        return GetOne(sql, new Object[]{id}, User.class);
    }

    /**
     * 根据用户账号和密码查看是否是此用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPwd (String username, String password) {
        String sql = "select * from user where username = ? and password = ? and isDelete = false";
        return GetOne(sql, new Object[]{username, password}, User.class);
    }

    /**
     * 保存当前用户信息！
     * @param user
     * @return
     */
    public int insertUser (User user) {
        String sql = "update user set username = ?, registerTime = ?, password = ?, lastLoginTime = ?, sex = ?, photo = ?, " +
                "loginIp = ?, isDelete = ?, status = ?, age = ? where username != ?";
        return insert(sql, new Object[]{user.getUsername(), user.getRegisterTime(), user.getPassword(), user.getLastLoginTime(),
                user.getSex(), user.getPhoto(), user.getLoginIp(), user.isDelete(), user.getStatus(), user.getAge(), user.getUsername()});
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("xmm");
        user.setRegisterTime(TimeUtil.getNow());
        user.setPassword("11111");
        user.setLastLoginTime(TimeUtil.getNow());
        user.setSex(1);
        user.setPhoto(PhotoInfoUtil.photo);
        user.setLoginIp("127.0.0.1");
        user.setDelete(false);
        user.setStatus(0);
        user.setAge(11);
        userDao.insertUser(user);
    }
}
