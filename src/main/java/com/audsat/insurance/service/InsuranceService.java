package com.audsat.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private CustomerService customerService;

    public void fetchInsuranceAnalysis() {

    }
}
