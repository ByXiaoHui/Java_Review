package com.xiaohui.test;

import com.xiaohui.entity.Emp;
import com.xiaohui.mapper.EmpMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName TestDemo01
 * @Author 何辉
 * @Date 2021/4/26 14:28
 **/
public class TestDemo03 {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream("SqlSessionFactory.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(inputStream);
        sqlSession = sessionFactory.openSession();
    }

    @Test
    public void testSelectEmp(){
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("a");
        List<Emp> a = mapper.findEmpByEname(emp);
        a.forEach(System.out::println);
    }

    @Test
    public void testSelectEmpno(){
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        /*List<Emp> a = mapper.findByEmpnos1(new int[]{7521,7839,7499});*/
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,7521,7839,7499);
        List<Emp> byEmpnos2 = mapper.findByEmpnos2(list);
        byEmpnos2.forEach(System.out::println);
    }


    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
