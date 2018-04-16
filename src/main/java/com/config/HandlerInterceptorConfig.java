package com.config;

import com.web.Interceptor.LoginInterceptor;
import com.web.Interceptor.UserInfoHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class HandlerInterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
        registry.addInterceptor(new UserInfoHandlerInterceptor());
    }

}
