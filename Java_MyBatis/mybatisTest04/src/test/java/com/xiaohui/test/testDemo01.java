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
    public void testFindDeptByDeptno(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptByDeptno = deptMapper.findDeptByDeptno(20);
        System.out.println(deptByDeptno.getDeptno());
//        System.out.println(deptByDeptno.getDeptno());
//        System.out.println(deptByDeptno.getDname());
//        System.out.println(deptByDeptno.getLoc());
//        List<Emp> empList = deptByDeptno.getEmpList();
//        empList.forEach(System.out::println);
    }

    @Test
    public void testAddDept(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("总部");
        dept.setLoc("北京");
        int i = mapper.insertDept(dept);
        sqlSession.commit();
    }

    @Test
    public void testUpdateDept(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptno(45);
        dept.setDname("后勤");
        dept.setLoc("教育网");
        int i = mapper.updateDept(dept);
        sqlSession.commit();
    }

    @Test
    public void testSelectDept(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept byDeptno = mapper.findByDeptno(45);
        System.out.println(byDeptno);
    }

    @Test
    public void testDeleteDept(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        int i = mapper.deleteDept(45);
        sqlSession.commit();
    }

    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
