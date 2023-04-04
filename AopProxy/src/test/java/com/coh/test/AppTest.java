package com.coh.test;

import com.coh.pojo.Car;
import com.coh.service.CarService;
import com.coh.service.CarServiceImplProxy;
import com.coh.service.impl.CarServiceImpl;
import org.junit.Test;
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
}
