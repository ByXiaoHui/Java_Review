package com.xiaohui.service.impl;

import com.xiaohui.dao.UserDao;
import com.xiaohui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author 何辉
 * @Date 2021/5/13 17:24
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(int userId, String userName) {
        System.out.println("userService add... ...");
        int res = userDao.addUser(userId,userName);
        return res;
    }
}
