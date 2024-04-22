package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.driver.DriverRepository;
import com.audsat.insurance.service.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverMapper mapper;

    @Autowired
    private DriverRepository repository;

    public void registerFromPoposal(final ProposalDTO proposal) {

        try {
            final Driver driver = mapper.toEntity(proposal);
            repository.save(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
