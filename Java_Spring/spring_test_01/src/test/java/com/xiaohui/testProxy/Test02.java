package com.xiaohui.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName Test02
 * @Author 何辉
 * @Date 2021/5/12 21:14
 **/
public class Test02 {
    public static void main(String[] args) {
        Dinner dinner = new Person("张三");

        //通过Proxy动态代理获得一个代理对象，在代理对象中，对某个方法进行增强
        // ClassLoader loader,被代理的对象的类加载器
        ClassLoader classLoader = dinner.getClass().getClassLoader();
        // Class<?>[] interfaces,被代理对象所实现的所有接口
        Class[] interaces= dinner.getClass().getInterfaces();
        // InvocationHandler h,执行处理器对象,专门用于定义增强的规则
        InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object proxy 代理对象
//                Method method 被代理的方法
//                Object[] args 被代理方法运行时的实参
                Object res = null;
                if(method.getName().equals("eat")){
                    System.out.println("饭前先洗手");
                    //让原有的eat方法去运行
                    res = method.invoke(dinner,args);
                    System.out.println("饭后洗碗");
                }else{
                    //让原有的drink方法去运行
                    res = method.invoke(dinner,args);
                }
                return res;
            }
        };

        Dinner dinnerProxy =(Dinner) Proxy.newProxyInstance(classLoader,interaces,invocationHandler);
        dinnerProxy.eat("包子");
//        dinnerProxy.drink();
    }
}

interface Dinner{
    void eat(String foodName);
    void drink();
}

class Person implements Dinner{
    private String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name+"正在吃"+foodName);
    }

    @Override
    public void drink() {
        System.out.println(name+"正在喝茶");
    }
}

class Student implements Dinner {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在食堂吃" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在喝可乐");
    }
}