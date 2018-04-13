package com.aop;

import com.common.Page;
import com.controller.Base;
import com.dao.UserDao;
import com.model.User;
import com.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UserInfoHandlerInterceptor implements HandlerInterceptor {


    @Autowired
    private UserDao userDao;

    /**
     * controller 执行之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截");
        Page page = new Page();
        //服务启动的时间
        page.setStartTime(TimeUtil.getNow());
        page.setRequest(request);
        page.setResponse(response);
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length < 1) {

        } else if (null != cookies || cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName() == "uuid") {
                    String uid = cookie.getValue();
                    if (StringUtils.isBlank(uid)) {
                        return false;
                    } else {
                        User user = userDao.findUserById(Integer.valueOf(uid));
                        page.setUser(user);
                    }
                }
            }
            //存储cookie
            page.setCookie(cookies);
        }
        Base.set(page);
        return true;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Base.set(null);
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
