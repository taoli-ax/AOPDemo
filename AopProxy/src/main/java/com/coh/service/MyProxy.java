package com.coh.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这是一个不完整的示例代码，只想说明AOP代理的原理
 * target=>aop>>target<<aop =>proxy
 * 就是装饰器闭包函数
 * 把target送入aop中加工
 */
public class MyProxy implements BeanPostProcessor {

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before init: "+beanName+" bean: "+bean);
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before目标execute");
                method.invoke(bean,args);
                System.out.println("after目标execute");
                return proxy;
            }
        });

    }


    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("after init:"+beanName+" bean: "+bean);
        return bean;
    }
}
