package com.java.spring.dao.impl;

import com.java.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("获取成功");
    }
}
