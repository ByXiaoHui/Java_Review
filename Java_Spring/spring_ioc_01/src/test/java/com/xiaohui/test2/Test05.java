package com.xiaohui.test2;

import com.xiaohui.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/11 14:55
 **/
public class Test05 {

    @Test
    public void testUser(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext5.xml");
        Book book = applicationContext.getBean("bookFactroy", Book.class);
        System.out.println(book);
    }

}
