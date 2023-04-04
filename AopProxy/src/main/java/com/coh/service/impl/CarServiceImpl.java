package com.coh.service.impl;

import com.coh.dao.CarDao;
import com.coh.pojo.Car;
import com.coh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
//    @Autowired
//    private CarDao carDao;
//
//    public void setCarDao(CarDao carDao) {
//        this.carDao = carDao;
//    }
//    public CarServiceImpl(CarDao carDao){
//        this.carDao=carDao;
//    }

    public void save() {
        System.out.println("carServiceImpl.save");
    }

    @Override
    public void delete() {

        System.out.println("carServiceImpl.delete");
//        int a=1/0;
    }

    @Override
    public void save2(Car car) {

    }
}
