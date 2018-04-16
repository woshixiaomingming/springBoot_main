package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PACKAGE})
public @interface MainMeau {

    /**
     * 当前方法的名
     * @return
     */
    String name() default "";

    /**
     * 描述
     * @return
     */
    String des() default "";

    /**
     * 返回的页面路径
     * @return
     */
    String path() default "";

}
