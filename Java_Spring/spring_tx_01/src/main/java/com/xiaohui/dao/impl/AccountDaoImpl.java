package com.xiaohui.dao.impl;

import com.xiaohui.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDaoImpl
 * @Author 何辉
 * @Date 2021/5/19 11:27
 **/
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int transMoney(int id, int money) {
        String sql = "update account set money = money+? where id=?";
        return jdbcTemplate.update(sql,money,id);
    }
}
