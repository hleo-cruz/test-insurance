package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.dto.request.DriverRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.customer.CustomerRepository;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.service.mapper.CustomerMapper;
import com.audsat.insurance.service.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private DriverCarService driverCarService;

    @Autowired
    private CustomerRepository repository;

    public Customer register(Customer customer) {

        try {

            return repository.save(customer);

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    private void markMainDriver(Long carId, Long driverId) {
        driverCarService.markMainDriver(carId, driverId);
    }

    public void register(final List<CustomerRequestDTO> customers, final Car car) {

        for(CustomerRequestDTO customerRequest : customers) {

            final DriverRequestDTO driverRequest = customerRequest.getDriverRequestDTO();
            final Driver driver = driverMapper.toEntity(driverRequest, car);
            final Customer customer = mapper.toEntity(customerRequest, driver);

            register(customer);

            if(driverRequest.getIsPrincipalDriver()) {
                markMainDriver(car.getId(), driver.getId());
            }
        }
    }


}
