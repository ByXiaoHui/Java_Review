package com.xiaohui.dao.impl;

import com.xiaohui.dao.DeptDao;
import com.xiaohui.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName DeptDaoImpl
 * @Author 何辉
 * @Date 2021/5/18 19:56
 **/
@Repository
public class DeptDaoImpl implements DeptDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @功能描述:批量增加操作
     */
    @Override
    public int[] deptBatchAdd(List<Dept> depts) {
        String sql = "insert into dept values(DEFAULT,?,?)";
        LinkedList<Object[]> args = new LinkedList<>();
        for (Dept dept : depts) {
            Object[] arg = {dept.getDname(), dept.getLoc()};
            args.add(arg);
        }
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        return ints;
    }

    @Override
    public int[] deptBatchUpdate(List<Dept> depts) {
        String sql = "update dept set dname =?, loc =? where deptno=?";
        LinkedList<Object[]> args = new LinkedList<>();
        for (Dept dept : depts) {
            Object[] arg = {dept.getDname(), dept.getLoc(),dept.getDeptno()};
            args.add(arg);
        }
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        return ints;
    }

    @Override
    public int[] deptBatchDelete(List<Integer> deptnos) {
        String sql = "delete from dept where deptno=?";
        LinkedList<Object[]> args = new LinkedList<>();
        for (Integer deptno : deptnos) {
            Object[] arg = {deptno};
            args.add(arg);
        }
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        return ints;
    }
}
