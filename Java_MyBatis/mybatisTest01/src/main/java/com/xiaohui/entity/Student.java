package com.xiaohui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Author 何辉
 * @Date 2021/4/26 14:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer student_id;
    private String student_name;
    private Integer classes_id;
}
