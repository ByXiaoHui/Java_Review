package com.xiaohui.test;

import com.xiaohui.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/19 11:58
 **/
//使用ExtentWith和ContextConfiguration注解
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//使用复合注解
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class Test03 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test03(){
        int rews = accountService.transMoney(1, 2, 100);
        System.out.println(rews);

    }
}
