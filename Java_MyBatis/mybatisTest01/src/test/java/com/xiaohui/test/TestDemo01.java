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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TestDemo01
 * @Author 何辉
 * @Date 2021/4/26 14:28
 **/
public class TestDemo01 {
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
    public void test01(){
        //调用sql语句
        List<Student> stuAll = sqlSession.selectList("stuAll");
        for (Student stu :stuAll){
            System.out.println(stu.toString());
        }
    }

    /**
     * 查询单个对象
     */
    @Test
    public void getTeacher(){
        //
        Teacher getTeacher = sqlSession.selectOne("getTeacher");
        System.out.println(getTeacher);
    }
    /**
     * 查询所有对象
     */
    @Test
    public void teacherAll(){
        List<Teacher> teacherAll = sqlSession.selectList("teacherAll");
//        for (Teacher teacher : teacherAll){
//            System.out.println(teacher);
//        }
        teacherAll.forEach(System.out::println);
    }

    /**
     * 查询多个对象的Map集合
     */
    @Test
    public void teacherAllMap(){
        Map<Integer, Teacher> teacherMap = sqlSession.selectMap("teacherAllMap", "teacher_id");
        Set<Integer> keySet = teacherMap.keySet();
        for (Integer integer : keySet) {
            System.out.println(integer+"："+teacherMap.get(integer));
        }
    }
    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
