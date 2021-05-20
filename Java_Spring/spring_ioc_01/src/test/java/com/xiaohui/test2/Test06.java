package com.xiaohui.test2;

import com.xiaohui.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/11 14:55
 **/
public class Test06 {

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext6.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步：User对象从容器中获取");
        System.out.println(user);
        //关闭容器
        applicationContext.close();
    }

}
