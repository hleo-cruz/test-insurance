package com.audsat.insurance.dto.response;

import com.audsat.insurance.dto.response.CarResponseDTO;
import com.audsat.insurance.dto.response.CustomerResponseDTO;
import com.audsat.insurance.repository.proposal.Proposal;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class ProposalResponseDTO {

    private UUID id;
    private List<CustomerResponseDTO> customers;
    private CarResponseDTO car;

    public ProposalResponseDTO(Proposal proposal) {
        this.id = proposal.getId();
        this.car = new CarResponseDTO(proposal.getCar());
        this.customers = proposal.getCustomers().stream().map(CustomerResponseDTO::new).collect(Collectors.toList());
    }

}
