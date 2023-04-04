package com.coh.service.impl;

import com.coh.dao.CarDao;
import com.coh.pojo.Car;
import com.coh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class CarServiceImpl4 implements CarService {

    public CarServiceImpl4() {
    }


    @Override
    public void save() {

        System.out.println("carServiceImpl4.save");
    }

    @Override
    public void delete() {

    }

    @Override
    public void save2(Car car) {

    }
}
