package com.xiaohui.test;

import com.xiaohui.pojo.Emp;
import com.xiaohui.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/18 17:29
 **/
public class Test01 {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService empService = applicationContext.getBean(EmpService.class);
        // 查询员工个数
        int empCount = empService.findEmpCount();
        System.out.println(empCount);
        // 根据员工编号查询员工对象
        Emp emp = empService.findByEmpno(7521);
        System.out.println(emp);
        //根据部门编号查询多个员工对象集合
        List<Emp> empList = empService.findByDeptno(20);
        empList.forEach(System.out::println);
        //增加员工信息
        int addEmprows = empService.addEmp(new Emp(null, "TOM", "SALESMAN", 7521, new Date(), 2000.0, 100.0, 10));
        System.out.println(addEmprows);
        //根据员工编号修改员工信息
        int updateEmprows = empService.updateEmp(new Emp(7936, "JERRY", "MANAGER", 7839, new Date(), 3000.0, 0.0, 20));
        System.out.println(updateEmprows);
        //根据员工编号删除员工信息
        int deleteEmprows = empService.deleteEmp(7936);
        System.out.println(deleteEmprows);
    }

}
