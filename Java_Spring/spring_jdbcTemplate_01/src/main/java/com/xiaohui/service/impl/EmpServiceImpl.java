package com.xiaohui.service.impl;

import com.xiaohui.dao.EmpDao;
import com.xiaohui.pojo.Emp;
import com.xiaohui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Author 何辉
 * @Date 2021/5/18 17:14
 **/
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    @Override
    public Emp findByEmpno(int empno) {
        return empDao.findByEmpno(empno);
    }

    @Override
    public List<Emp> findByDeptno(int deptno) {
        return empDao.findByDeptno(deptno);
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }
}
