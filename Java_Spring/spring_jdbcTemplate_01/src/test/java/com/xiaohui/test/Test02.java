package com.xiaohui.test;

import com.xiaohui.pojo.Dept;
import com.xiaohui.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/18 17:29
 **/
public class Test02 {
    @Test
    public void testDeptBatchAdd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> depts =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            depts.add(new Dept(null,"name"+i,"loc"+i));
        }
        int[] ints = deptService.deptBatchAdd(depts);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testDeptBatchUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> depts =new ArrayList<>();
        for (int i = 46; i <= 55; i++) {
            depts.add(new Dept(i,"newName"+i,"newLoc"+i));
        }
        int[] ints = deptService.deptBatchUpdate(depts);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testDeptBatchDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Integer> deptnos =new ArrayList<>();
        for (int i = 46; i <= 55; i++) {
            deptnos.add(i);
        }
        int[] ints = deptService.deptBatchDelete(deptnos);
        System.out.println(Arrays.toString(ints));
    }
}
