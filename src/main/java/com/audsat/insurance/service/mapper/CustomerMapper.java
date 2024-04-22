package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private DriverMapper driverMapper;

    public Customer toEntity(ProposalDTO proposal) {
        return Customer.builder()
                .name(proposal.getCustomerName())
                .driver(driverMapper.toEntity(proposal))
                .build();
    }
}
