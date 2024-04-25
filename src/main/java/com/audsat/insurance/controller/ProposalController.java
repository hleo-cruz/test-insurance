package com.audsat.insurance.controller;

import com.audsat.insurance.dto.request.ProposalRequestDTO;
import com.audsat.insurance.dto.response.ProposalResponseDTO;
import com.audsat.insurance.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/proposal")
public class ProposalController {

    @Autowired
    private ProposalService service;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ProposalResponseDTO register(@RequestBody ProposalRequestDTO proposal) {
        return service.register(proposal);
    }
}
