package com.xiaohui.dao.impl;

import com.xiaohui.dao.EmpDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName EmpDaoImpl
 * @Author 何辉
 * @Date 2021/5/17 16:09
 **/
@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(int empno, String ename, String job) {
        System.out.println("EmpDao add... ...");
        return 0;
    }
}
