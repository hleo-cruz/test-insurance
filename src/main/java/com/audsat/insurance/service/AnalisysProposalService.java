package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.ProposalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalisysProposalService {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    public void applyAnalysis(final Long analysisId) {

        try {

            final ProposalDTO proposal = proposalService.findById(analysisId);
            customerService.registerFromPoposal(proposal);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
