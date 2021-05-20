package com.xiaohui.test;

import com.xiaohui.config.SpringConfig;
import com.xiaohui.dao.EmpDao;
import com.xiaohui.dao.UserDao;
import com.xiaohui.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/17 17:14
 **/
public class Test01 {
    @Test
    public void getBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        int res = userDao.addUser(1, "张三");
        System.out.println(res);
//        System.out.println("---------------");
//        EmpDao empDao = applicationContext.getBean(EmpDao.class);
//        int empRes = empDao.addEmp(1, "Java", "aaa");
//        System.out.println(empRes);
    }

    @Test
    public void getBean2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        int addUser = userDao.addUser(1, "张三");
        System.out.println(addUser);
    }

    @Test
    public void getBean3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        int addUser = userDao.addUser(1, "张三");
        System.out.println(addUser);
    }
}
