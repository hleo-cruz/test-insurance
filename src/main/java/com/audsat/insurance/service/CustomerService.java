package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.customer.CustomerRepository;
import com.audsat.insurance.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private CustomerRepository repository;

    public void registerFromPoposal(final ProposalDTO proposal) {

        try {
            final Customer customer = mapper.toEntity(proposal);
            repository.save(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
