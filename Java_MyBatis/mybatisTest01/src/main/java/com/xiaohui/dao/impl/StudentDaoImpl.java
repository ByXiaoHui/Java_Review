package com.xiaohui.dao.impl;

import com.xiaohui.dao.StudentDao;
import com.xiaohui.entity.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Author 何辉
 * @Date 2021/4/27 14:13
 **/
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> stuAll() {
        SqlSession session;

        return null;
    }
}
