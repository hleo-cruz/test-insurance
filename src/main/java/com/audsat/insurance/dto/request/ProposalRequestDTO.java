package com.audsat.insurance.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProposalRequestDTO {

    private List<CustomerRequestDTO> customers;
    private CarRequestDTO car;
}
