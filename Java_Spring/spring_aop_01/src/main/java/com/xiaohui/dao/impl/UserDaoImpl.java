package com.xiaohui.dao.impl;

import com.xiaohui.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Author 何辉
 * @Date 2021/5/13 17:26
 **/
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(int userId, String userName) {
        System.out.println("userDao add... ...");
        return 1;
    }
}
