package com.yy.common.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @package: com.yy.common.annotaion
 * @className: Login
 * @author: Created By Yy
 * @date: 2020-08-28 14:28
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

}
