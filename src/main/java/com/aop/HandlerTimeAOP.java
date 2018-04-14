package com.aop;

import com.controller.Base;
import com.util.IPUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class HandlerTimeAOP {

    private static Logger logger = Logger.getLogger(HandlerTimeAOP.class);

    @Pointcut("execution(* com.controller..*.*(..))")
    public void pointCut () {

    }

    @Before(value = "pointCut()")
    public void before (JoinPoint point) {
        System.out.println("aop");
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowIng (JoinPoint point) {
        //请求的url
        logger.error("请求的URL =（" + Base.get().getRequest().getRequestURL() + ")");

        //请求method
        logger.error("请求的method =（" + Base.get().getRequest().getMethod() + ")");

        //请求的ip
        logger.error("请求的ip =（" + IPUtil.getIP(Base.get()) + ")");

        //切面的接口方法
        logger.error("发生异常的类方法 =（" + point.getSignature().getName() + "," + point.getSignature().getDeclaringTypeName() + ")");

        //发生异常时的用户
        logger.error("请求的用户 =（" + Base.get().getUser() + ")");
    }
}
