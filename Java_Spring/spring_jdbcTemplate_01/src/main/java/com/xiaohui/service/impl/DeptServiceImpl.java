package com.xiaohui.service.impl;

import com.xiaohui.dao.DeptDao;
import com.xiaohui.pojo.Dept;
import com.xiaohui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Author 何辉
 * @Date 2021/5/18 19:55
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public int[] deptBatchAdd(List<Dept> depts) {
        return deptDao.deptBatchAdd(depts);
    }

    @Override
    public int[] deptBatchUpdate(List<Dept> depts) {
        return deptDao.deptBatchUpdate(depts);
    }

    @Override
    public int[] deptBatchDelete(List<Integer> deptnos) {
        return deptDao.deptBatchDelete(deptnos);
    }
}
