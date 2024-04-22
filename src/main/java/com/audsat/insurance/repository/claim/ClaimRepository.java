package com.audsat.insurance.repository.claim;

import com.audsat.insurance.repository.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
