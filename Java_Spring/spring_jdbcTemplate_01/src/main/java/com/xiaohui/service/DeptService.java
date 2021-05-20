package com.xiaohui.service;

import com.xiaohui.pojo.Dept;

import java.util.List;

public interface DeptService {
    int[] deptBatchAdd(List<Dept> depts);

    int[] deptBatchUpdate(List<Dept> depts);

    int[] deptBatchDelete(List<Integer> deptnos);
}
