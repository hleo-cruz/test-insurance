package com.audsat.insurance.service.check;

import com.audsat.insurance.repository.proposal.Proposal;

import java.math.BigDecimal;
import java.util.UUID;

public interface CheckIncreaseCost {

    public static final BigDecimal INCREASE_TAX = new BigDecimal(2.0);

    public Boolean check(Proposal proposal);
}
