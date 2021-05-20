package com.xiaohui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfig
 * @Author 何辉
 * @Date 2021/5/12 17:27
 **/
@ComponentScan(basePackages = "com.xiaohui")
@PropertySource("classpath:aaa.properties")
public class SpringConfig {
}
