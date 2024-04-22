package com.audsat.insurance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDTO {

    private String customerName;
    private DriverDTO driver;
    private CarDTO car;
}
