package com.xiaohui.test2;

import com.xiaohui.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/12 14:34
 **/
public class Test01 {
    @Test
    public void testGetBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = applicationContext.getBean("user", User.class);
        System.out.println(user1);
    }
}
