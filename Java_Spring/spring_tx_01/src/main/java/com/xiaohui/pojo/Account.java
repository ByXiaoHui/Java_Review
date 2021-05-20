package com.xiaohui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Account
 * @Author 何辉
 * @Date 2021/5/19 11:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Integer money;
}
