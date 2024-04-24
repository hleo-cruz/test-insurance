package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.ProposalRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toEntityFromProposal(ProposalRequestDTO proposal) {
        return new Car(proposal.getCar());
    }

}
