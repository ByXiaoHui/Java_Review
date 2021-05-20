package com.xiaohui.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName DaoAspect
 * @Author 何辉
 * @Date 2021/5/17 17:13
 **/
@Aspect
@Component
@Order(1)
public class DaoAspect {

    //定义公共切点  切点表达式直接指向接口
    @Pointcut("execution(* com.xiaohui.dao.*.add*(..))")
    public void addPointcut(){}

    /**
     * 前置通知：切点方法执行前先执行的功能
     * 参数列表可以用JoinPoint接收切点对象
     * 可以获取方法执行的参数
     */
    @Before("addPointcut()")
    public void methodBefore(JoinPoint joinPoint){
        System.out.println("methodBefore invoke... ...");
        Object[] args = joinPoint.getArgs();
        System.out.println("args:"+ Arrays.toString(args));
    }

    /**
     * 后置通知:方法执行之后要增强的功能
     * 论切点方法是否出现异常都会执行的方法
     * 参数列表可以用JoinPoint接收切点对象
     */
    @After("addPointcut()")
    public void methodAfter(JoinPoint joinPoint){
        System.out.println("methodAfter invoke... ...");
    }

    /**
     * 返回通知：切点方法正常运行结束后增强的功能
     * 如果方法运行过程中出现异常，则该功能不运行
     * 参数可以用JoinPoint joinPoint接收切点对象
     * 可以用Object res接收方法返回值，需要用returning指定返回值名称
     */
    @AfterReturning(value = "addPointcut()",returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint,Object res){
        System.out.println("methodAfterReturning invoke... ...");
    }

    /**
     * 异常通知：切点方法出现异常运行时的增强功能
     * 如果方法运行没有出现异常，则该功能不运行
     * 参数列表可以用Exception exception接收异常对象，需要通过throwing指定异常名称
     */
    @AfterThrowing(value = "addPointcut()",throwing = "exception")
    public void methodAfterThrowing(Exception exception){
        System.out.println("methodAfterThrowing invoke... ...");
    }

    /**
     * 环绕通知：在切点方法之前和之后都进行功能的增强
     * 参数列表需要带上一个特殊的形参
     * 需要在通知中定义方法执行的位置，并在执行位置之前和之后自定义增强的功能
     * 方法列表可以通过ProceedingJoinPoint获取执行的切点（手动控制切点方法执行的位置）
     *  环绕通知的返回值必须是Object  在环绕通知中必须要将切点方法继续向上返回
     */
    @Around("addPointcut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("methodAroundA invoke... ...");
        Object proceed = proceedingJoinPoint.proceed();//控制切点方法在这里执行
        System.out.println("methodAroundB invoke... ...");
        return proceed;
    }
}
