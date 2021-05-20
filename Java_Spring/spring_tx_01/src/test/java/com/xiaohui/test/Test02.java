package com.xiaohui.test;

import com.xiaohui.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/19 11:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test02 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test03(){
        int rews = accountService.transMoney(1, 2, 100);
        System.out.println(rews);

    }
}
