package com.java.spring.service.impl;

import com.java.spring.dao.UserDao;
import com.java.spring.dao.impl.UserDaoImpl;
import com.java.spring.dao.impl.UserDaoMysqlImpl;
import com.java.spring.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Author 何辉
 * @Date 2021/3/19 23:57
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public  void setUserDao(UserDao userDao){
        this.userDao = userDao;
    };

    @Override
    public void getUserServiceImpl() {
        userDao.getUser();
    }
}
