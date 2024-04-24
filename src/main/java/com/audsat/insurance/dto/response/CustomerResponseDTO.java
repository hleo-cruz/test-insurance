package com.audsat.insurance.dto.response;

import com.audsat.insurance.repository.customer.Customer;
import lombok.Getter;

@Getter
public class CustomerResponseDTO {

    private String customerName;
    private DriverResponseDTO driver;

    public CustomerResponseDTO(Customer customer){
        this.customerName = customer.getName();
        this.driver = new DriverResponseDTO(customer.getDriver());
    }
}
