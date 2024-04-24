package com.audsat.insurance.service.mapper;

import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.proposal.Proposal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProposalMapper {

    public Proposal toEntentity(List<Customer> customers, Car car) {
        return new Proposal(customers, car);
    }


}
