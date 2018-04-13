package com.util;

import com.common.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AddPageUtil {

    public static Page getRequest () {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        Page page = new Page();
        page.setRequest(request);
        return page;
    }

    public static void addCookie (String userId, Page page) {
        Cookie cookie = new Cookie("uuid", userId);
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        cookie.setDomain("main.com");
        page.getResponse().addCookie(cookie);
    }

}
