package com.xiaohui.test;

import com.xiaohui.entity.Dept;
import com.xiaohui.entity.Emp;
import com.xiaohui.mapper.DeptMapper;
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

/**
 * @ClassName testDemo01
 * @Author 何辉
 * @Date 2021/4/30 23:24
 **/
public class testDemo02 {
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
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findByEmpno(7521);
        System.out.println(emp);

        // 中间发生了增删改或者是调用了SqlSession调用了commit,会自动清空缓存
        sqlSession.commit();// 增删改的时候调用

        EmpMapper mapper2 = sqlSession.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findByEmpno(7521);
        System.out.println(emp2);

        System.out.println(emp==emp2);
        System.out.println(mapper==mapper2);
    }

    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
