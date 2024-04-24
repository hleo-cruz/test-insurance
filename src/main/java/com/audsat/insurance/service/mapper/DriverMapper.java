package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.DriverRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    @Autowired
    private CarMapper carMapper;

    public Driver toEntity(DriverRequestDTO driver, Car car) {
        return new Driver(driver);
    }

}
