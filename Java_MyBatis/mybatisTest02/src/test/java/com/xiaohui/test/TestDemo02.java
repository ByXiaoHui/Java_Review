package com.xiaohui.test;

import com.xiaohui.entity.Dept;
import com.xiaohui.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TestDemo01
 * @Author 何辉
 * @Date 2021/4/26 14:28
 **/
public class TestDemo02 {
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
    public void testAddDept(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null, "JAva", "BOSTON");
        System.out.println(dept.getDeptno());
        mapper.addDept(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());
    }

    @Test
    public void testAddDept2(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null, "JAva", "BOSTON");
        System.out.println(dept.getDeptno());
        mapper.addDept2(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());
    }

    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
