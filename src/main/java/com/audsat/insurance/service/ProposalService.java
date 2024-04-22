package com.audsat.insurance.service;

import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.customer.CustomerRepository;
import com.audsat.insurance.repository.proposal.Proposal;
import com.audsat.insurance.repository.proposal.ProposalRepository;
import com.audsat.insurance.service.event.AnalisysProposalEventPublisher;
import com.audsat.insurance.service.mapper.ProposalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProposalService {

    @Autowired
    private ProposalMapper mapper;

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private AnalisysProposalEventPublisher eventPublisher;

    public void register(final ProposalDTO proposalDTO) {

        try {
            final Proposal proposalToSave = mapper.toEntity(Optional.of(proposalDTO));
            final Proposal proposal = repository.save(proposalToSave);
            eventPublisher.publish(proposal.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ProposalDTO findById(final Long proposalId) {

        try {
            final Optional<Proposal> proposal = repository.findById(proposalId);
            return mapper.toDto(proposal);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
