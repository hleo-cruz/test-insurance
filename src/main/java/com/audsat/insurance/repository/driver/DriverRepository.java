package com.audsat.insurance.repository.driver;

import com.audsat.insurance.repository.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
