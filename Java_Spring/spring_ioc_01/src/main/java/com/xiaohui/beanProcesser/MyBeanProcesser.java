package com.xiaohui.beanProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName MyBeanProcesser
 * @Author 何辉
 * @Date 2021/5/11 20:35
 **/
public class MyBeanProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //Object bean      实例化的bean
        //String beanName  bean的id
        System.out.println("bean:初始化方法之前");
        return bean;// 这里必须return bean
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean:初始化方法之后");
        return bean;// 这里必须return bean
    }
}
