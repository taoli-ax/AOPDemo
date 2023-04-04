package com.coh.test;

import com.coh.pojo.Car;
import com.coh.service.CarService;
import com.coh.service.CarServiceImplProxy;
import com.coh.service.MyAdvice;
import com.coh.service.impl.CarServiceImpl;
import com.coh.service.impl.CarServiceImpl3;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    @Test
    public void TestStaticProxy(){
        CarService carService=new CarServiceImplProxy(new CarServiceImpl());
        carService.save();
    }
    @Test
    public void TestDynamicProxy(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app.xml");
        CarService carService= (CarService) applicationContext.getBean("carServiceImpl");
        carService.save();
        carService.delete();
    }

    @Test
    public void testAspectJ(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app2.xml");
        CarService carService= (CarService) applicationContext.getBean("carServiceImpl2");
        carService.save();
    }

    @Test
    public void txTest(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app3.xml");
        CarService carService=(CarService) applicationContext.getBean("carServiceImpl3");
        Car car=new Car();
        car.setName("Trailblazer2");
        car.setBrand("chevrolet");
        carService.save2(car);

    }
    @Test
    public void TestProxyFactoryPrevious(){
        ProxyFactory proxyFactory=new ProxyFactory();
        // 通知+目标对象=代理对象
        proxyFactory.setTarget(new CarServiceImpl3());
        proxyFactory.addAdvice(new MyAdvice());
        CarService carService=(CarService) proxyFactory.getProxy();
        carService.save();
    }

}
