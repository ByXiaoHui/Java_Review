package com.xiaohui.dao;

import com.xiaohui.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> teacherAll();
    Teacher getTeacher();
}
