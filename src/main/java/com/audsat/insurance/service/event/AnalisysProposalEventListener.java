package com.audsat.insurance.service.event;

import com.audsat.insurance.service.AnalisysProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AnalisysProposalEventListener implements ApplicationListener<AnalisysProposalEvent> {

    @Autowired
    private AnalisysProposalService service;

    @Override
    public void onApplicationEvent(final AnalisysProposalEvent event) {
        final Long analysisId = event.getAnalysisId();
        service.applyAnalysis(analysisId);
    }
}
