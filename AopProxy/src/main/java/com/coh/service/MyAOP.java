package com.coh.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.cache.interceptor.CacheOperationInvoker;

public class MyAOP {
    public void before(){
        System.out.println("MyAOP.before");
    }
    public void after(){
        System.out.println("MyAOP.after");
    }
    public void exception(){
        System.out.println("MyAOP.exception");
    }
    public void afterReturning(){
        System.out.println("MyAOP.afterReturning");
    }

    /**
     * 执行连接点对应的方法
     * @param proceedingJoinPoint 当前连接点，当前被切面切入的方法
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed=null;
        try{
            System.out.println("事务开始 前置通知");
            proceed=proceedingJoinPoint.proceed();
            System.out.println("事务提交 返回通知");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("事务回滚 异常通知");

        }finally {
            System.out.println("事务关闭 后置通知");
        };
        return proceed;

    }
}
