package com.xiaohui.test;

import com.xiaohui.entity.Dept;
import com.xiaohui.entity.Emp;
import com.xiaohui.entity.Project;
import com.xiaohui.entity.ProjectRecord;
import com.xiaohui.mapper.DeptMapper;
import com.xiaohui.mapper.EmpMapper;
import com.xiaohui.mapper.ProjectMapper;
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
public class testDemo03 {
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
    public void testfindProjectJoinEmpsByPid(){
        ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = mapper.findProjectJoinEmpsByPid(2);
        System.out.println(project.getPid());
        System.out.println(project.getPname());
        System.out.println(project.getMoney());
        List<ProjectRecord> projectRecords = project.getProjectRecords();
        for(ProjectRecord projectRecord : projectRecords){
            Emp emp = projectRecord.getEmp();
            System.out.println(emp);
        }

    }



    @After
    public void release(){
        //关闭sqlSession
        sqlSession.close();
    }
}
