package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.cars.CarRepository;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.customer.CustomerRepository;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.service.mapper.CarMapper;
import com.audsat.insurance.service.mapper.CustomerMapper;
import com.audsat.insurance.service.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CarService {

    @Autowired
    private CarMapper mapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private CarRepository repository;

    public void registerFromPoposal(final ProposalDTO proposal) {

        try {
            final Car car = mapper.toEntity(proposal.getCar());
            Driver driver = driverMapper.toEntity(proposal);
//            car.setDrivers(Arrays.asList(driver));÷
            repository.save(car);
        } catch (Exception ex) {

        }
    }
}
