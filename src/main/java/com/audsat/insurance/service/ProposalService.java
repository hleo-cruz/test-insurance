package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.dto.request.DriverRequestDTO;
import com.audsat.insurance.dto.request.ProposalRequestDTO;
import com.audsat.insurance.dto.response.ProposalResponseDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.proposal.Proposal;
import com.audsat.insurance.repository.proposal.ProposalRepository;
import com.audsat.insurance.service.mapper.CarMapper;
import com.audsat.insurance.service.mapper.CustomerMapper;
import com.audsat.insurance.service.mapper.DriverMapper;
import com.audsat.insurance.service.mapper.ProposalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    private ProposalMapper mapper;

    @Autowired
    private ProposalRepository repository;

    public Proposal findById(UUID proposalId) {
        try {

            return repository.getOne(proposalId);

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public ProposalResponseDTO register(final ProposalRequestDTO proposal) {

        try {

            final Car car = carMapper.toEntityFromProposal(proposal);
            final List<Customer> customers = mapCustomerList(proposal, car);
            final Proposal proposalSaved = repository.save(mapper.toEntentity(customers, car));

            return prepareResponse(proposalSaved);

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    private List<Customer> mapCustomerList(ProposalRequestDTO proposal, Car car) {

        return proposal.getCustomers().stream().map(customer -> {

            final Driver driver = mapDriver(customer, car);
            return customerMapper.toEntity(customer, driver);

        }).collect(Collectors.toList());
    }

    private Driver mapDriver(CustomerRequestDTO customer, Car car) {
        final DriverRequestDTO driverRequest = customer.getDriverRequestDTO();
        return driverMapper.toEntity(driverRequest, car);
    }

    private ProposalResponseDTO prepareResponse (Proposal proposal) {
        return new ProposalResponseDTO(proposal);
    }
}
