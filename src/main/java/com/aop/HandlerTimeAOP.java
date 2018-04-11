package com.aop;

import com.common.Page;
import com.dao.UserDao;
import com.model.User;
import com.util.AddPage;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HandlerTimeAOP {

    @Autowired
    private UserDao userDao;

    @Before("execution(* com.controller..*.*(..))")
    public void before (JoinPoint point) {
        long startTime = System.currentTimeMillis();
        Page page = AddPage.getRequest();
        HttpServletRequest request = page.getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() == "uid") {
                String uid = cookie.getValue();
                if (StringUtils.isBlank(uid)) {
                    return;
                } else {
                    User user = userDao.findUserById(Integer.valueOf(uid));
                }
            }
        }
        System.out.println("cnm");
    }

}
