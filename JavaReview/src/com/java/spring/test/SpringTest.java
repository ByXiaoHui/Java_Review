package com.java.spring.test;

import com.java.spring.dao.impl.UserDaoImpl;
import com.java.spring.dao.impl.UserDaoMysqlImpl;
import com.java.spring.service.UserService;
import com.java.spring.service.impl.UserServiceImpl;

/**
 * @ClassName SpringTest
 * @Author 何辉
 * @Date 2021/3/20 0:03
 **/
public class SpringTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        userService.getUserServiceImpl();
    }
}
