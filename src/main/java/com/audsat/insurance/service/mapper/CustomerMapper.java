package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private DriverMapper mapper;

    public Customer toEntity(CustomerRequestDTO customer, Driver driver) {
        return new Customer(customer, driver);
    }

}
