package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.dto.request.ProposalRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.service.mapper.CarMapper;
import com.audsat.insurance.service.mapper.CustomerMapper;
import com.audsat.insurance.service.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProposalService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    public void register(final ProposalRequestDTO proposal) {

        try {

            final Car car = carMapper.toEntityFromProposal(proposal);
            List<CustomerRequestDTO> customers = proposal.getCustomers();
           customerService.register(customers, car);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
