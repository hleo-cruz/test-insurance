package com.audsat.insurance.controller;

import com.audsat.insurance.dto.response.InsuranceResponseDTO;
import com.audsat.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @GetMapping("proposal/{proposalId}")
    public InsuranceResponseDTO fetchInsuranceAnalysis(@PathVariable("proposalId") UUID proposalId) {
        return service.processProposal(proposalId);
    }
}
