package com.audsat.insurance.service.event;

import org.springframework.context.ApplicationEvent;

public class AnalisysProposalEvent extends ApplicationEvent {

    private Long analysisId;

    public AnalisysProposalEvent(Object source, Long analysisId) {
        super(source);
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() {
        return analysisId;
    }
}
