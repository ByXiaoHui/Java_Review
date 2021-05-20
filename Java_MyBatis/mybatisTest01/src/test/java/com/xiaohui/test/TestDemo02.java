package com.xiaohui.test;

import com.xiaohui.entity.Student;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestDemo02
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
    public void getTeacher(){
        //测试单个基本数据类型作为参数
        Teacher getTeacher = sqlSession.selectOne("getTeacher", 1);
        System.out.println(getTeacher);
    }

    @Test
    public void getTeacherMap(){
        //测试Map集合作为参数
        Map<String,Object> args= new HashMap<>();
        args.put("name","老罗");
        args.put("salary",2000);
        List<Teacher> getTeacherMap = sqlSession.selectList("getTeacherMap", args);
        getTeacherMap.forEach(System.out::println);
    }

    @Test
    public void getTeacherArg(){
        //测试对象作为参数
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(2);
        teacher.setTeacher_name("老罗");
        List<Teacher> getTeacherMap = sqlSession.selectList("getTeacherArg", teacher);
        getTeacherMap.forEach(System.out::println);
    }

    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
