package com.xiaohui.mapper;

import com.xiaohui.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DeptMapper {
    Dept findDeptByDeptno(int deptno);

    @Select("select * from dept where deptno = #{deptno}")
    Dept findByDeptno(int deptno);

    @Update("update dept set dname = #{dname} , loc = #{loc} where deptno = #{deptno}")
    int updateDept(Dept dept);

    @Insert("insert into dept values(DEFAULT,#{dname},#{loc})")
    int insertDept(Dept dept);

    @Delete("delete from dept where deptno = #{deptno}")
    int deleteDept(int deptno);
}
