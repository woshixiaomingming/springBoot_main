package com.controller;

import com.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Test {

    @RequestMapping("/main")
    public String test (HttpServletResponse response) {
        /*Cookie cookie = new Cookie("uuid", "111");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        cookie.setDomain("main.com");
        response.addCookie(cookie);*/
        return "ok";
    }

    //@RequestMapping("/login")
    public String login (@RequestParam User user) {

        return "";
    }
}
