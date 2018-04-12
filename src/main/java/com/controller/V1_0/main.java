package com.controller.V1_0;

import com.alibaba.fastjson.JSONObject;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class main {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JSONObject login (@RequestParam String username, @RequestParam String password) {
        return userService.loginAuth(username, password);
    }

}
