package com.service;

import com.alibaba.fastjson.JSONObject;
import com.common.Page;
import com.dao.UserDao;
import com.entity.Message;
import com.entity.enums.UserLoginStatus;
import com.entity.enums.UserStatus;
import com.entity.webEntity.UserEntity;
import com.model.User;
import com.util.AddPageUtil;
import com.util.RtnInfoReflexUtil;
import com.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RtnInfoReflexUtil reflex;

    /**
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    public JSONObject loginAuth (String username, String password, Page page) {
        User user = userDao.findByUsernameAndPwd(username, password);
        if (null == user) {
            Message msg = new Message("1001", "FAIL");
            JSONObject json = msg.getReturnInfo();
            return json;
        } else {
            Message msg = new Message("1000", "SUCCESS");
            JSONObject json = msg.getReturnInfo();
            //数据库数据反射到接口数据
            UserEntity userEntity = reflex.getRtnInfo(UserEntity.class, user);
            json.put("data", userEntity);
            new AddPageUtil().addCookie(String.valueOf(user.getId()), page);
            page.setUser(user);
            page.setIsLogin(UserLoginStatus.SUCCESS.getKey());
            return json;
        }
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param code
     * @param sex
     * @param photo
     * @param loginIp
     * @param isDelete
     * @param status
     * @param age
     * @return
     */
    public JSONObject register (String username, String password, int sex, String photo, String loginIp, boolean isDelete, int status, int age, String code, Page page) {
        if (password.length() > 16 || password.length() < 6) {
            Message msg = new Message("1001", "FAIL");
            JSONObject json = msg.getReturnInfo();
            return json;
        }
        //验证验证码code

        User user = new User(username, TimeUtil.getNow(), password, TimeUtil.getNow(), sex, photo, loginIp, isDelete, status, age);
        if (userDao.insertUser(user) > 0) {
            Message msg = new Message("1000", "SUCCESS");
            JSONObject json = msg.getReturnInfo();
            json.put("data", reflex.getRtnInfo(UserEntity.class, user));
            new AddPageUtil().addCookie(String.valueOf(user.getId()), page);
            page.setUser(user);
            page.setIsLogin(UserLoginStatus.SUCCESS.getKey());
            return json;
        }
        Message msg = new Message("1001", "FAIL");
        JSONObject json = msg.getReturnInfo();
        return json;
    }


    public JSONObject getUserInfo () {
        AddPageUtil addPageUtil = new AddPageUtil();
        Message msg = new Message("1000", "SUCCESS");
        JSONObject json = msg.getReturnInfo();
        json.put("user", addPageUtil.userId());
        return json;
    }
}
