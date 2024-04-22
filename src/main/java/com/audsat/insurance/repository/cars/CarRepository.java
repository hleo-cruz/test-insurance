package com.audsat.insurance.repository.cars;

import com.audsat.insurance.repository.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
