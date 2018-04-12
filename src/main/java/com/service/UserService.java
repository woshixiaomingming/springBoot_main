package com.service;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.entity.Message;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public JSONObject loginAuth (String username, String password) {
        User user = userDao.findByUsernameAndPwd(username, password);
        if (null == user) {
            Message msg = new Message("1001", "fail");
            JSONObject json = msg.getReturnInfo();
            return json;
        } else {
            Message msg = new Message("1000", "SUCCESS");
            JSONObject json = msg.getReturnInfo();
            json.put("data", user);
            return json;
        }
    }

}
