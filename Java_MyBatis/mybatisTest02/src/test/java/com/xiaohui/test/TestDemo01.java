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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //查询全部员工信息
    @Test
    public void testFindAll(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //查询全部员工信息
        List<Emp> empMapperAll = empMapper.findAll();
        empMapperAll.forEach(System.out::println);
    }

    //使用单个参数进行查询某个员工信息
    @Test
    public void testFindByEmpno(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp byEmpno = empMapper.findByEmpno(7499);
        System.out.println(byEmpno);
    }

    //多个参数进行查询某个员工信息
    @Test
    public void testFindByEmpnoAndSal(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> byEmpnoAndSal = empMapper.findByDeptnoAndSal(20, 3000.0);
        byEmpnoAndSal.forEach(System.out::println);
    }

    //Map形式进行查询某个员工信息
    @Test
    public void testFindByEmpnoAndSalMap(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",20);
        map.put("sal",3000.0);
        List<Emp> byEmpnoAndSal = empMapper.findByDeptnoAndSalMap(map);
        byEmpnoAndSal.forEach(System.out::println);
    }

    //单个引用类型进行查询某个员工信息
    @Test
    public void testFindByEmp(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(3000.0);
        List<Emp> byEmpnoAndSal = empMapper.findByDeptnoAndSalEmp(emp);
        byEmpnoAndSal.forEach(System.out::println);
    }

    //多个引用类型进行查询某个员工信息
    @Test
    public void testFindByEmpList(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp();
        emp1.setDeptno(20);
        Emp emp2 = new Emp();
        emp2.setSal(3000.0);
        List<Emp> byEmpnoAndSal = empMapper.findByDeptnoAndSalEmpList(emp1,emp2);
        byEmpnoAndSal.forEach(System.out::println);
    }

    //模糊查询
    @Test
    public void testFindByEname(){
        //获取接口
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> byEname = empMapper.findByEname("a");
        byEname.forEach(System.out::println);
    }

    @Test
    public void testAddEmp(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.addEmp(new Emp(null, "TOM", "SALESMAN", 7521, new Date(), 2314.0, 100.0, 10));
        sqlSession.commit();
    }
    @Test
    public void testUpdateEnameByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.updateEnameByEmpno(7935, "TOM");
        sqlSession.commit();
    }
    @Test
    public void testDeletByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.deleteByEmpno(7935);
        sqlSession.commit();
    }


    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
