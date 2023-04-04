package com.coh.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 描述为切面类
 */
@Aspect
@Component
public class MyAOP2 {
    /**
     * execution中
     * 第一个 * 返回类型
     * 第二个 * 类
     * 第三个 * 方法
     * 第一个..包和子包下的所有类
     * 第二个 .. 方法的所有参数类型
     */
    @Pointcut("execution(* com.coh.service..*.*(..))")
    public void pointCut(){

    }

    @Pointcut("execution(* com.coh.dao..*.*(..))")
    public void pointCut2(){

    }

    @Before("pointCut()")
    public void former(){
        System.out.println("MyAOP2.former");
    }
    @After("pointCut()")
    public void behind(){
        System.out.println("MyAOP2.behind");
    }

    @AfterReturning("pointCut()")
    public void AfterReturning(){
        System.out.println("MyAOP2.afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing(){
        System.out.println("MyAOP2.afterThrowing");
    }

    /**
     * around方法可以替代所有以上的方法
     * @param joinPoint 当时切入的具体方法
     * @return
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed=null;
        try {
            System.out.println("环绕 start and former");
            proceed=joinPoint.proceed();
            System.out.println("#success and return");
        } catch (Throwable e) {
            System.out.println("!exception and rollBack");
            throw new RuntimeException(e);
        }finally {
            System.out.println("环绕 end and behind");
        }
        return proceed;
    }
}
