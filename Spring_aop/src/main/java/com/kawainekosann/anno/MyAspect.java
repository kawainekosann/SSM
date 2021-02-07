package com.kawainekosann.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注当前类是一个切面类
public class MyAspect {
    @Before("execution(* com.kawainekosann.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强");
    }
    public void afterReturning(){
        System.out.println("后置增强");
    }
    public void afterThrowing(){
        System.out.println("异常抛出增强");
    }

    @Around("pointcut()")
    //Proceeding JoinPoint 正在执行的连接点===切点
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前。。。");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后。。。");
        return proceed;
    }
    @Around("MyAspect.pointcut()")
    public void after(){
        System.out.println("最终增强");
    }

    //定义切点表达式
    @Pointcut("execution(* com.kawainekosann.anno.*.*(..))")
    public void pointcut(){};
}
