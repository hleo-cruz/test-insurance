package com.audsat.insurance.service.event;

import com.audsat.insurance.service.AnalisysProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AnalisysProposalEventPublisher implements ApplicationEventPublisherAware {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(Long analysisProposalId) {
        AnalisysProposalEvent event = new AnalisysProposalEvent(this, analysisProposalId);
        this.publisher.publishEvent(event);
    }
}
