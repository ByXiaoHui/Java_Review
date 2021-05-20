package com.xiaohui.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName SpringConfig
 * @Author 何辉
 * @Date 2021/5/19 16:30
 **/
//@Configuration //配置类的标志注解
//@ComponentScan(basePackages = "com.xiaohui")//spring包扫描
//@PropertySource("classpath:jdbc.properties")//读取配置文件
//@EnableTransactionManagement//开启事务注解
public class SpringConfig {

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;

    /*创建数据库连接池*/
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        return druidDataSource;
    }

    /*创建JdbcTemplate对象*/
    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /*创建事务管理器*/
    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
