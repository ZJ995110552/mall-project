package com.mercury.mallproject.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//目标是方法
public @interface OperationLogger {

    String modelName() default "";

    //首先是被调用的方法的名称，其默认值是“”
    String user();

    //接下了一个就是当前使用这个方法的用户是谁
    String option();
}