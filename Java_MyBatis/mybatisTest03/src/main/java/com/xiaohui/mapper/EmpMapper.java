package com.xiaohui.mapper;

import com.xiaohui.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 何辉
 * @Date: 2021/4/29 14:14
 */
public interface EmpMapper {
    /**
     * @功能描述:根据员工编号查询员工所有信息并携带所在部门信息
     * @param empno 要查询的员工编号
     * @return Emp对象,组合了Dept对象作为属性,对部门信息进行存储
     */
   Emp findEmpJoinDeptByEmpno(int empno);

}
