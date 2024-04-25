package com.audsat.insurance.service.check;

import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.proposal.Proposal;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class CheckAgeRangeIncreaseCost implements CheckIncreaseCost {

    @Override
    public Boolean check(Proposal proposal) {

        final Driver driver = proposal.getCustomers().stream()
                .filter(customer -> customer.getDriver().getIsMainDriver())
                .map(customerFiltered -> customerFiltered.getDriver())
                .findFirst().get();

        final LocalDate birthDate = driver.getBirthDate();
        final LocalDate now = LocalDate.now();
        long years = java.time.temporal.ChronoUnit.YEARS.between( birthDate , now );


        return years >= 18 && years <= 25;
    }

}
