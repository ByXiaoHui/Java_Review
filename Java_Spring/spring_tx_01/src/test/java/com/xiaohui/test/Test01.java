package com.xiaohui.test;

import com.xiaohui.config.SpringConfig;
import com.xiaohui.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/19 11:58
 **/
public class Test01 {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        int rews = accountService.transMoney(1, 2, 100);
        System.out.println(rews);

    }

    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        int rews = accountService.transMoney(1, 2, 100);
        System.out.println(rews);

    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        int rews = accountService.transMoney(1, 2, 100);
        System.out.println(rews);

    }
}
