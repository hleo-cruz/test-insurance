package com.audsat.insurance.service;

import com.audsat.insurance.dto.response.InsuranceResponseDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.insurance.Insurance;
import com.audsat.insurance.repository.insurance.InsuranceRepository;
import com.audsat.insurance.repository.proposal.Proposal;
import com.audsat.insurance.service.check.CheckIncreaseCost;
import com.audsat.insurance.service.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class InsuranceService {

    private static final BigDecimal BASE_TAX = new BigDecimal(0.06);

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private InsuranceRepository repository;

    @Autowired
    private InsuranceMapper mapper;

    @Autowired
    private List<CheckIncreaseCost> increaseCosts;


    public InsuranceResponseDTO processProposal(UUID propososalId) {

        final Proposal proposal = proposalService.findById(propososalId);
        BigDecimal cost = calculateBaseCost(proposal.getCar());

        for(CheckIncreaseCost checkIncreaseCost: increaseCosts) {
            final Boolean check = checkIncreaseCost.check(proposal);
            if(check) {
                cost = cost.multiply(CheckIncreaseCost.INCREASE_TAX);
            }
        };

        final Insurance insurance = persistInsurance(proposal, cost);

        return mapper.toResponseDTO(insurance);

    }

    private Insurance persistInsurance(final Proposal proposal, final BigDecimal cost) {
        final Insurance insurance = new Insurance(proposal, cost);
        return repository.save(insurance);
    }

    private BigDecimal calculateBaseCost(final Car car) {
        final BigDecimal fipeValue = BigDecimal.valueOf(car.getFipeValue());
        return fipeValue.multiply(BASE_TAX);
    }
}
