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
     * @功能描述:查询全部的员工信息
     */
    List<Emp> findAll();

    /**
     * @功能描述:查询单个基本数据类型
     */
    Emp findByEmpno(int empno);

    /**
     * @功能描述:根据员工编号和薪资下限去查询员工信息
     */
    List<Emp> findByDeptnoAndSal(@Param("deptno") int deptno,@Param("sal") double sal);

    /**
     * @功能描述:使用Map集合来根据员工编号和薪资下限去查询员工信息
     */
    List<Emp> findByDeptnoAndSalMap(Map<String,Object> map);

    /**
     * @功能描述:单个引用类型
     */
    List<Emp> findByDeptnoAndSalEmp(Emp emp);

    /**
     * @功能描述:多个引用类型
     */
    List<Emp> findByDeptnoAndSalEmpList(@Param("emp1") Emp emp1,@Param("emp2") Emp emp2);

    /**
     * @功能描述:
     */
    List<Emp> findByEname( String name);

    /**
     * 增加员工信息
     * @param emp 存储新增员工信息的Emp对象
     * @return 对数据库数据产生影响的行数
     */
    int addEmp(Emp emp);
    /**
     * 根据员工编号修改员工姓名的方法
     * @param empno 要修改的员工编号
     * @param ename 修改之后的新的员工名字
     * @return 对数据库数据产生影响的行数
     */
    int updateEnameByEmpno(@Param("empno") int empno,@Param("ename") String ename);
    /**
     * 根据员工编号删除员工信息
     * @param empno 要删除的员工编号
     * @return 对数据库数据产生影响的行数
     */
    int deleteByEmpno(int empno);

}
