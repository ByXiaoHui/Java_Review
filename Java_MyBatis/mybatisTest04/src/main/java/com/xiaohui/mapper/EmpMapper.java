package com.xiaohui.mapper;

import com.xiaohui.entity.Emp;

import java.util.List;

/**
 * @Author: 何辉
 * @Date: 2021/4/29 14:14
 */
public interface EmpMapper {
    List<Emp> findEmpsByDeptno(int deptno);

    Emp findByEmpno(int empno);
}
