package com.coh.service;

import com.coh.pojo.Car;
import com.coh.service.impl.CarServiceImpl;

public class CarServiceImplProxy implements CarService {
    CarServiceImpl carServiceImpl;

    public CarServiceImplProxy(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @Override
    public void save() {
        System.out.println("Aop Static Proxy start!");
        this.carServiceImpl.save();
        System.out.println("Aop Static Proxy end!");
    }

    @Override
    public void delete() {

    }

    @Override
    public void save2(Car car) {

    }
}
