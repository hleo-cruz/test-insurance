package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.DriverDTO;
import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DriverMapper {

    @Autowired
    private CarMapper carMapper;

    public Driver toEntity(ProposalDTO proposal) {

        final DriverDTO driver = proposal.getDriver();
        final Car car = carMapper.toEntity(proposal.getCar());

        return Driver.builder()
                .document(driver.getDocument())
                .birthDate(driver.getBirthdate())
                .cars(Arrays.asList(car))
                .build();
    }
}
