package com.xiaohui.service.impl;

import com.xiaohui.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmpServiceImpl
 * @Author 何辉
 * @Date 2021/5/17 16:06
 **/
@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public int addEmp(int empno, String ename, String job) {
        System.out.println("EmpService add... ...");
        return 0;
    }
}
