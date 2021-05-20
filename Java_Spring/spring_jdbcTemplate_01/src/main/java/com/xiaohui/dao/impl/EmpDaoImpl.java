package com.xiaohui.dao.impl;

import com.xiaohui.dao.EmpDao;
import com.xiaohui.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName EmpDaoImpl
 * @Author 何辉
 * @Date 2021/5/18 17:15
 **/
@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findEmpCount() {
        /**
         * @功能描述:查询员工个数
         * jdbcTemplate.queryForObject
         * 1.sql语句
         * 2.返回值类型字节码
         */
        String sql = "select count(1) from emp";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

    /**
     * @功能描述:查询单个员工信息
     * jdbcTemplate.queryForObject
     * 1.sql语句
     * 2.RowMapper接口中的一个实现类对象，用于指定结果集用什么实体类进行封装
     * 3.sql语句中需要传入的参数 可变参数
     */
    @Override
    public Emp findByEmpno(int empno) {
        String sql = "select * from emp where empno = ? ";
        BeanPropertyRowMapper<Emp> beanPropertyRowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
        Emp emp = jdbcTemplate.queryForObject(sql, beanPropertyRowMapper, empno);
        return emp;
    }

    /**
     * @功能描述:查询多个员工对象集合
     * jdbcTemplate.query
     * 1.sql语句
     * 2.RowMapper接口中的一个实现类对象，用于指定结果集用什么实体类进行封装
     * 3.sql语句中需要传入的参数 可变参数
     */
    @Override
    public List<Emp> findByDeptno(int deptno) {
        String sql = "select * from emp where deptno = ?";
        BeanPropertyRowMapper<Emp> beanPropertyRowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);
        List<Emp> empList = jdbcTemplate.query(sql, beanPropertyRowMapper, deptno);
        return empList;
    }

    /**
     * @功能描述:增加员工信息
     * jdbcTemplate.update
     * 1.sql语句
     * 2.sql语句中的需要的参数
     */
    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into emp values(DEFAULT,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),
                emp.getComm(),emp.getDeptno()};
        int addEmpCount = jdbcTemplate.update(sql, args);
        return addEmpCount;
    }

    /**
     * @功能描述:修改某个员工的信息
     * jdbcTemplate.update
     * 1.sql语句
     * 2.sql语句中的需要的参数
     */
    @Override
    public int updateEmp(Emp emp) {
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno =?";
        Object[] args = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),
                emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        int updateEmpCount = jdbcTemplate.update(sql, args);
        return updateEmpCount;
    }

    /**
     * @功能描述:删除某个员工信息
     * jdbcTemplate.update
     * 1.sql语句
     * 2.sql语句中的需要的参数
     */
    @Override
    public int deleteEmp(int empno) {
        String sql = "delete from emp where empno =?";
        int deleteEmpCount = jdbcTemplate.update(sql, empno);
        return deleteEmpCount;
    }
}
