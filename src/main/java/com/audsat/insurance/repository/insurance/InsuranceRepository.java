package com.audsat.insurance.repository.insurance;

import com.audsat.insurance.repository.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
