package com.xiaohui.test;

import com.xiaohui.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/10 23:53
 **/
public class Test01 {
    @Test
    public void testAddEmp(){
        //获取一个容器对象，并读取spring.xml文件，实例化配置文件中的配置的对象后，自动放入容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //通过容器的ID来获取对象的对象
        EmpDao empDao = applicationContext.getBean("empDao",EmpDao.class);
        //调用方法测试
        empDao.addEmp();
    }
}
