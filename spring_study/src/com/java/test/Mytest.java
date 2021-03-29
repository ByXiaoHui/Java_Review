package com.java.test;

import com.java.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Mytest
 * @Author 何辉
 * @Datn person = (Person) context.getBean("person");
 * //        System.out.println(person);e 2021/3/21 16:14
 **/
public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//        Person person = (Person) context.getBean("person");
//        System.out.println(person);
    }
}
