package com.xrluo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect {

    @Pointcut("execution(** com.xrluo.classes.DemoBase.speak(..))")
    public void pointcut() {

    }


    @Before("pointcut()")
    public void beforeDemo1() {
        System.out.println("beforeDemo1...........................");
    }

    @Before("pointcut()")
    public void beforeDemo2() {
        System.out.println("beforeDemo2...........................");
    }

    @After("pointcut()")
    public void afterDemo2() {
        System.out.println("afterDemo2............................");
    }

    @After("pointcut()")
    public void afterDemo1() {
        System.out.println("afterDemo1............................");
    }


    @Before("execution(** com.xrluo.classes.*.*(Integer)) && args(integer)")
    public void before3(Integer integer) {
        System.out.println("切入点 参数integer:" + integer + "........................");
    }


}
