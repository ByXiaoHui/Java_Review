package com.xiaohui.test2;

import com.xiaohui.config.SpringConfig;
import com.xiaohui.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/12 14:34
 **/
public class Test02 {
    @Test
    public void testGetBean(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserServiceImpl userServiceImpl = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.add();
    }

    @Test
    public void testGetBean2(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl userServiceImpl = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.add();
    }
}
