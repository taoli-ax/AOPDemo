package com.coh.service;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAdvice.before："+method.getName()+" -- "+target.getClass()+" -- "+args.length);



    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAdvice.afterReturning："+method.getName()+" -- "+target.getClass()+" -- "+args.length);
    }
}
