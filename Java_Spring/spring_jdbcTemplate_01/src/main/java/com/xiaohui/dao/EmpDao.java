package com.xiaohui.dao;

import com.xiaohui.pojo.Emp;

import java.util.List;

public interface EmpDao {

    int findEmpCount();

    Emp findByEmpno(int empno);

    List<Emp> findByDeptno(int deptno);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empno);
}
