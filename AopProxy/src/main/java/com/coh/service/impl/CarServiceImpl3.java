package com.coh.service.impl;

import com.coh.dao.CarDao;
import com.coh.pojo.Car;
import com.coh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl3 implements CarService {
    @Autowired
    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }
    public CarServiceImpl3(CarDao carDao){
        this.carDao=carDao;
    }

    public CarServiceImpl3() {
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,rollbackForClassName = "java.lang.RunTimeException")
    @Override
    public void save2(Car car) {
        carDao.insert(car);
        throw new RuntimeException("exception! rollback");
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
