package com.audsat.insurance.dto.response;

import com.audsat.insurance.repository.insurance.Insurance;
import com.audsat.insurance.repository.proposal.Proposal;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class InsuranceResponseDTO {

    private UUID id;
    private Double cost;
    private List<CustomerResponseDTO> customers;
    private CarResponseDTO car;

    public InsuranceResponseDTO(Insurance insurance) {
        this.id = insurance.getId();
        this.cost = insurance.getCost();
        this.car = new CarResponseDTO(insurance.getCar());
        this.customers = insurance.getCustomers().stream().map(CustomerResponseDTO::new).collect(Collectors.toList());
    }
}
