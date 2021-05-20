package com.xiaohui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Dept
 * @Author 何辉
 * @Date 2021/5/18 19:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
}
