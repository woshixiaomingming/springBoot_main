package com.util;

import com.common.Page;
import com.controller.Base;
import com.dao.UserDao;
import com.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPageUtil {

    private UserDao userDao = new UserDao();

    public static HttpServletRequest getRequest () {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }

    /**
     * 添加cookie信息
     * @param userId
     * @param page
     */
    public void addCookie (String userId, Page page) {
        Cookie cookie = new Cookie("uuid", userId);
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        cookie.setDomain("main.com");
        page.getResponse().addCookie(cookie);
    }

    /**
     * 根据当前的用户返回当前的用户信息
     * @return
     */
    public User userId () {
        //csrf防盗链接
        if (!IPUtil.getReferer()) {
            return null;
        }
        return getUserId();
    }

    /**
     * cookie中获取用户信息
     * @return
     */
    public User getUserId () {
        Page page = Base.get();
        Cookie[] cookies = page.getCookie();
        if (cookies != null || cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    return userDao.findUserById(Integer.valueOf(cookie.getValue()));
                }
            }
        }
        return null;
    }
}
