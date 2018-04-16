package com.annotation;

import com.entity.enums.Operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MainAuth {

    boolean isAuth() default true;

    Operation operation();

    String desc() default "";

}
