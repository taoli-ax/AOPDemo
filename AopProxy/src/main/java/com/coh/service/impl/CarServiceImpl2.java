package com.coh.service.impl;

import com.coh.dao.CarDao;
import com.coh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl2 implements CarService {

    public void save() {
        System.out.println("carServiceImpl.save");
    }

    @Override
    public void delete() {

        System.out.println("carServiceImpl.delete");
//        int a=1/0;
    }
}
