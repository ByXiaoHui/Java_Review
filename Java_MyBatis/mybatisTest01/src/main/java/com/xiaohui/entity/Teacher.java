package com.xiaohui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Teachers
 * @Author 何辉
 * @Date 2021/4/27 14:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    private Integer teacher_id;
    private String teacher_name;
    private Integer teacher_salary;
}
