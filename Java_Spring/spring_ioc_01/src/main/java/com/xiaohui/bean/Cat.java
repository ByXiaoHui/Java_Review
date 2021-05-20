package com.xiaohui.bean;

/**
 * @ClassName Cat
 * @Author 何辉
 * @Date 2021/5/11 16:33
 **/
public class Cat {
    private String name;
    private Mouse mouse1;

    public Cat(String name, Mouse mouse1) {
        this.name = name;
        this.mouse1 = mouse1;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mouse getMouse1() {
        return mouse1;
    }

    public void setMouse1(Mouse mouse1) {
        this.mouse1 = mouse1;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", mouse1=" + mouse1 +
                '}';
    }
}
