package com.yy.common.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @package: com.yy.common.annotaion
 * @className: NoResult
 * @author: Created By Yy
 * @date: 2020-08-07 16:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoResult {

}
