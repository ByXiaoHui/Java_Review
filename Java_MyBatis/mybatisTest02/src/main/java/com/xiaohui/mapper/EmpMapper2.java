package com.xiaohui.mapper;

import com.xiaohui.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 何辉
 * @Date: 2021/4/29 14:14
 */
public interface EmpMapper2 {
    List<Emp> findByCondition(Emp emp);
    List<Emp> findEmpByCondition(Emp emp);
    List<Emp> findEmpByCondition2(Emp emp);
    int updateEmpByCondtion(Emp emp);
    List<Emp> findEmpByCondition3(Emp emp);
    List<Emp> findEmpByEname(Emp emp);

    List<Emp> findByEmpnos1(int[] empnos);
    List<Emp> findByEmpnos2(List<Integer> empnos);
}
