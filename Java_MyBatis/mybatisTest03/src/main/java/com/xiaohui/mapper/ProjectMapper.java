package com.xiaohui.mapper;

import com.xiaohui.entity.Project;

/**
 * @ClassName ProjectMapper
 * @Author 何辉
 * @Date 2021/5/7 18:15
 **/
public interface ProjectMapper {
    /**
     * @功能描述:根据项目编号查询一个项目信息及参与该项目的所有员工信息
     * @Param pid 项目信息
     * @return  所有信息封装的Project对象
     */
    Project findProjectJoinEmpsByPid(int pid);
}
