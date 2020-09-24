package com.yy.common.annotaion;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @package: com.yy.common.annotaion
 * @className: Lock
 * @author: Created By Yy
 * @date: 2020-08-18 20:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limit {

    boolean isLock() default false;

    long lockExpireTime() default 10L;

    TimeUnit lockUnit() default TimeUnit.SECONDS;

    String key() default "";
    
    int interval() default 60;
    
    int count() default 10;
    
    boolean isForbidUser() default true;
    
}
