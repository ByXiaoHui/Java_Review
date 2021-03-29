package com.java.spring.dao.impl;

import com.java.spring.dao.UserDao;

/**
 * @ClassName UserDaoMysqlImpl
 * @Author 何辉
 * @Date 2021/3/20 0:08
 **/
public class UserDaoMysqlImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("从Mysql获取用户");
    }
}
