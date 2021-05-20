package com.xiaohui.bean;

/**
 * @ClassName Emp
 * @Author 何辉
 * @Date 2021/5/11 20:58
 **/
public class Emp {
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
