package com.aop;

import com.common.Page;
import com.controller.Base;
import com.dao.UserDao;
import com.model.User;
import com.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import java.sql.Timestamp;

/**
 * 处理page对象
 */
public class UserInfoHandlerInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(UserInfoHandlerInterceptor.class);

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
        page.setStartTime(TimeUtil.getNow());
        page.setRequest(request);
        page.setResponse(response);
        //当前的cookie信息
        page.setCookie(request.getCookies());
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
        long startTime = Base.get().getStartTime().getTime();
        long endTime = System.currentTimeMillis();
        logger.info("请求完成时间：" + (endTime - startTime) + "ms");
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
