package com.coh.config;

import com.coh.dao.CarDao;
import com.coh.dao.CupDao;
import com.coh.dao.impl.CupDaoImpl;
import com.coh.pojo.CarExample;
import com.coh.service.CarService;
import com.coh.service.impl.CarServiceImpl3;
import com.coh.service.impl.CarServiceImpl4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class JavaConfig {

    // 相当于<bean id="" class="" />
    @Bean
    public CarService carServiceImpl4(){
        return new CarServiceImpl4();
    }
}
