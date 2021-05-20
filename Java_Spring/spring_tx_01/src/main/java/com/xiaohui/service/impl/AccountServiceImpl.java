package com.xiaohui.service.impl;

import com.xiaohui.dao.AccountDao;
import com.xiaohui.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AccountServiceImpl
 * @Author 何辉
 * @Date 2021/5/19 11:29
 **/
@Service
//@Transactional //加在类上，代表该类的所有方法都添加了事务控制
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT) //放在方法上，就是仅仅对当前方法添加了事务控制
    @Override
    @Transactional
    public int transMoney(int from, int to, int money) {
        int rows = 0;
        rows += accountDao.transMoney(from, 0 - money);
        //模拟异常
//        int i=1/0;
        rows += accountDao.transMoney(to, money);
        return rows;
    }
}
