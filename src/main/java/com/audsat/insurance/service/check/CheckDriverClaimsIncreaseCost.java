package com.audsat.insurance.service.check;

import com.audsat.insurance.repository.claim.Claim;
import com.audsat.insurance.repository.claim.ClaimRepository;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.proposal.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class CheckDriverClaimsIncreaseCost implements CheckIncreaseCost{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public Boolean check(Proposal proposal) {

        Boolean hasClaim = false;

        for(Customer customer: proposal.getCustomers()) {
            final Driver driver = customer.getDriver();
            final Claim claim = claimRepository.findByDriverId(driver.getId());
            hasClaim = claim != null;
        }

        return hasClaim;
    }
}
