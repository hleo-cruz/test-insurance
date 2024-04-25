package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.response.CustomerResponseDTO;
import com.audsat.insurance.dto.response.DriverResponseDTO;
import com.audsat.insurance.dto.response.InsuranceResponseDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.insurance.Insurance;
import com.audsat.insurance.repository.proposal.Proposal;
import org.hibernate.persister.collection.mutation.InsertRowsCoordinatorTablePerSubclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InsuranceMapper {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private DriverMapper driverMapper;

    public InsuranceResponseDTO toResponseDTO(Insurance insurance) {
        return new InsuranceResponseDTO(insurance);
    }


}
