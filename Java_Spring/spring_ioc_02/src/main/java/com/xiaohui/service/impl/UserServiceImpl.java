package com.xiaohui.service.impl;

import com.xiaohui.dao.UserDao;
import com.xiaohui.dao.impl.UserDaoImplA;
import com.xiaohui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @ClassName UserServiceImpl
 * @Author 何辉
 * @Date 2021/5/12 15:21
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImplB")
    private UserDao userDao;

//    @Resource(name="userDaoImplA")
//    private UserDao userDao;

    //普通属性赋值
    @Value("${sname}")
    private String sname;
    @Value("${sgender}")
    private String sgender;
    @Value("${sage}")
    private Integer sage;

    @Override
    public void add() {
        System.out.println("UserServiceImpl add...");
        System.out.println(sname);
        System.out.println(sgender);
        System.out.println(sage);
        userDao.add();
    }
}
