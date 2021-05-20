package com.xiaohui.test2;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/11 14:55
 **/
public class Test08 {

    @Test
    public void testUser() throws SQLException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext8.xml");
        DruidDataSource druidDataSource = applicationContext.getBean("druidDataSource", DruidDataSource.class);
        System.out.println(druidDataSource);
    }

}
