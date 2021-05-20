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

/**
 * @ClassName testDemo01
 * @Author 何辉
 * @Date 2021/4/30 23:24
 **/
public class testDemo03 {
    private SqlSession sqlSession;
    private SqlSession sqlSession2;
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
        sqlSession2 = sessionFactory.openSession();
    }

    @Test
    public void testFindByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findByEmpno(7521);
        System.out.println(emp);
        // SqlSession提交之后,才会将查询的结果放入二级缓存
        sqlSession.commit();

        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);
        Emp emp2 = mapper2.findByEmpno(7521);
        System.out.println(emp2);

        System.out.println(emp==emp2);
        System.out.println(mapper==mapper2);
    }

    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
        sqlSession2.close();
    }
}
