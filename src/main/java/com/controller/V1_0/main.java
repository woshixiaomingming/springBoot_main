package com.controller.V1_0;

import com.alibaba.fastjson.JSONObject;
import com.common.Page;
import com.controller.Base;
import com.entity.UserStatus;
import com.service.UserService;
import com.util.AddPageUtil;
import com.util.IPUtil;
import com.util.PhotoInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/V1_0")
public class main extends Base {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JSONObject login (@RequestParam String username, @RequestParam String password) {
        JSONObject json = userService.loginAuth(username, password,  get());
        return json;
    }

    @RequestMapping("/register")
    public JSONObject register (@RequestParam String username, @RequestParam String password, @RequestParam String code, @RequestParam int sex, @RequestParam int age) {
        return userService.register(username, password, sex, PhotoInfoUtil.photo, IPUtil.getIP(get()), false, UserStatus.NORMAL.getKey(), age, code, get());
    }

}
