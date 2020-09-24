package com.yy.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @package: com.yy.source.common.util
 * @className: SpringUtil
 * @author: Created By 94035
 * @date: 2020-06-05 23:00
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static  <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }

    public static <T> T getBean(String name,Class<T> tClass){
        return applicationContext.getBean(name,tClass);
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}
