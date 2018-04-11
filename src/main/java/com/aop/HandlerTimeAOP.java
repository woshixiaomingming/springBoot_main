package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class HandlerTimeAOP {


    @Before("execution(* com.controller..*.*(..))")
    public void before (JoinPoint point) {
        System.out.println("aop");
    }

}
