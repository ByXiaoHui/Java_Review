package com.xiaohui.test2;

import com.xiaohui.bean.Cat;
import com.xiaohui.bean.Mouse;
import com.xiaohui.bean.Student;
import com.xiaohui.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/11 14:55
 **/
public class Test01 {

    @Test
    public void testUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println(user1);
        System.out.println("-----------------");
        User user2 = applicationContext.getBean("user2", User.class);
        System.out.println(user2);
        System.out.println("-----------------");
        User user3 = applicationContext.getBean("user3", User.class);
        System.out.println(user3);
        System.out.println("-----------------");
        User user4 = applicationContext.getBean("user4", User.class);
        System.out.println(user4);
        System.out.println("-----------------");
    }

    @Test
    public void testUser2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        System.out.println("-----------------");

    }

    @Test
    public void testMouse(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Mouse mouse = applicationContext.getBean("mouse", Mouse.class);
        System.out.println(mouse);

    }

    @Test
    public void testCat(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Cat cat = applicationContext.getBean("cat1", Cat.class);
        System.out.println(cat.toString());

        Cat cat2 = applicationContext.getBean("cat2", Cat.class);
        System.out.println(cat2.toString());

        Cat cat3 = applicationContext.getBean("cat3", Cat.class);
        System.out.println(cat3.toString());

    }

    @Test
    public void testStudent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext4.xml");
        Student student = applicationContext.getBean("student1", Student.class);
        System.out.println(Arrays.toString(student.getBooks()));
        System.out.println(student.getBookList());
        System.out.println(student.getBookSet());
        System.out.println(student.getBookMap());
        System.out.println(student.getBookList2());

    }
}
