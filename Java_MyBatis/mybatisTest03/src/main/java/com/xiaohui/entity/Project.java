package com.xiaohui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Project
 * @Author 何辉
 * @Date 2021/5/7 18:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private Integer pid;
    private String pname;
    private Integer money;
    // 组合一个ProjectRecord对象集合作为属性
    private List<ProjectRecord> projectRecords;
}
