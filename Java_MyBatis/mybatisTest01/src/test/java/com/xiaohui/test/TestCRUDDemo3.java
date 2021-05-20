package com.xiaohui.test;

import com.xiaohui.entity.Teacher;
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
 * @ClassName TestCRUDDemo3
 * @Author 何辉
 * @Date 2021/4/27 22:55
 **/
public class TestCRUDDemo3 {
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
        sqlSession = sessionFactory.openSession(true);
    }

    /**
     * 增删改时，需要提交事务
     * sqlSession.commit();手动提交事务
     * sqlSession = sessionFactory.openSession(true);设置事务自动提交
     */
    @Test
    public void insertTeacher(){
        //增加方法
        Teacher teacher = new Teacher(null,"猪猪",1200);
        int addTeacher = sqlSession.insert("addTeacher", teacher);
        System.out.println(addTeacher);
    }

    @Test
    public void updateTeacher(){
        //修改方法
        Teacher teacher = new Teacher(1,"早上好",3500);
        int updateTeacher = sqlSession.insert("updateTeacher", teacher);
        System.out.println(updateTeacher);
    }

    @Test
    public void deleteTeacher(){
        //删除方法
        int deleteTeacher = sqlSession.insert("deleteTeacher", 8);
        System.out.println(deleteTeacher);
    }


    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
