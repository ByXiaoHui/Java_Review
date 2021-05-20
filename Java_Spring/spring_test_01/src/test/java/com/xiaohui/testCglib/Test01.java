package com.xiaohui.testCglib;


import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName Test01
 * @Author 何辉
 * @Date 2021/5/13 15:17
 **/
public class Test01 {
    @Test
    public void testCglib() {
        //获取一个Person对象
        Person person = new Person();
        //1、获得一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2、设置父类字节码
        enhancer.setSuperclass(person.getClass());
        //3、获取MethodInterceptor对象，用于定义增强规则
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                /*
                Object o, 生成后的代理对象  personProxy
                Method method,  父类中原来要执行的方法 Person >>> eat()
                Object[] objects,  方法在调用时传入的实参数组
                MethodProxy methodProxy 子类中重写父类的方法 personProxy >>> eat()
                */
                Object res = null;
                if (method.getName().equals("eat")) {
                    System.out.println("饭前请洗手");
                    res = methodProxy.invokeSuper(o, objects);
                    System.out.println("饭后请洗碗");
                } else {
                    res = methodProxy.invokeSuper(o, objects);
                }
                return res;
            }
        };
        //4、回调设置methodInterceptor
        enhancer.setCallback(methodInterceptor);
        //5、获取代理对象
        Person person1 = (Person) enhancer.create();
        //6、使用代理对象完成功能
        person1.eat("包子");
    }
}

class Person {
    public Person() {
    }

    public void eat(String foodName) {
        System.out.println("张三正在吃" + foodName);
    }
}

class Son extends Person{
    public Son() {
        super();
    }

    @Override
    public void eat(String foodName) {
        System.out.println("饭前请洗手");
        super.eat(foodName);
        System.out.println("饭后请洗碗");
    }
}

