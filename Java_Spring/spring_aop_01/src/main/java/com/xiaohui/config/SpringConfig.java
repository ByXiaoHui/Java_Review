package com.xiaohui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName SpringConfig
 * @Author 何辉
 * @Date 2021/5/18 16:23
 **/
@Configuration
@ComponentScan("com.xiaohui")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
