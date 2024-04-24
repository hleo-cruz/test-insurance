package com.audsat.insurance.controller;

import com.audsat.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @GetMapping
    public void fetchInsuranceAnalysis() {
        service.fetchInsuranceAnalysis();
    }
}
