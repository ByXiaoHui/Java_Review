package com.xiaohui.dao;

import com.xiaohui.pojo.Dept;

import java.util.List;

public interface DeptDao {
    int[] deptBatchAdd(List<Dept> depts);

    int[] deptBatchUpdate(List<Dept> depts);

    int[] deptBatchDelete(List<Integer> deptnos);
}
