package com.xiaohui.dao.impl;

import com.xiaohui.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImplA
 * @Author 何辉
 * @Date 2021/5/12 15:19
 **/
@Repository
public class UserDaoImplB implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImplB  add...");
    }
}
