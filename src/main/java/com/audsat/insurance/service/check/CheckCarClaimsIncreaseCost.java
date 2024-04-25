package com.audsat.insurance.service.check;

import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.claim.Claim;
import com.audsat.insurance.repository.claim.ClaimRepository;
import com.audsat.insurance.repository.proposal.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CheckCarClaimsIncreaseCost implements CheckIncreaseCost{


    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public Boolean check(Proposal proposal) {

        final Car car = proposal.getCar();
        final Claim claim = claimRepository.findByCarId(car.getId());
        return claim != null;
    }
}
