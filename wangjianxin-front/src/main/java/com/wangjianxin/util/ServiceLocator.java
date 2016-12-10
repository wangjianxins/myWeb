package com.wangjianxin.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * Created by zhaobk on 2015-07-23.
 * 获取bean的工具类，可用于jsp页面及listener调用
 */
public class ServiceLocator implements ApplicationContextAware {

    private final static ServiceLocator instance = new ServiceLocator();
    private ApplicationContext context;

    public static ServiceLocator getInstance() {
        return instance;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        instance.context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return instance.context.getBean(beanName);
    }

    public static void publishEvent(ApplicationEvent event) {
        instance.context.publishEvent(event);
    }
}