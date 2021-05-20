package com.xiaohui.test;

import com.xiaohui.entity.Emp;
import com.xiaohui.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName testDemo01
 * @Author 何辉
 * @Date 2021/4/30 23:24
 **/
public class testDemo01 {
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
    public void testFindAll(){

    }


    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
