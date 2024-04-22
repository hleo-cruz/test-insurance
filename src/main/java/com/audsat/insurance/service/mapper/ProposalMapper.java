package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.CarDTO;
import com.audsat.insurance.dto.request.DriverDTO;
import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.proposal.Proposal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ProposalMapper {

    public Proposal toEntity(final Optional<ProposalDTO> proposal) {

        return proposal.map(prop -> {

            return Proposal.builder()
                    .customerName(prop.getCustomerName())
                    .document(prop.getDriver().getDocument())
                    .birthDate(prop.getDriver().getBirthdate())
                    .modelYear(prop.getCar().getYear())
                    .fipeValue(prop.getCar().getFipeValue().doubleValue())
                    .modelCar(prop.getCar().getModel())
                    .manufacturer(prop.getCar().getManufacturer())
                    .build();

        }).get();

    }

    public ProposalDTO toDto(final Optional<Proposal> proposal) {

        return proposal.map(prop -> {

            return ProposalDTO.builder()
                    .customerName(prop.getCustomerName())
                    .driver(toDriverDTO(prop))
                    .car(toCarDTO(prop))
                    .build();

        }).get();
    }

    private DriverDTO toDriverDTO(Proposal proposal) {
        return DriverDTO.builder()
                .fgMainDriver(true)
                .document(proposal.getDocument())
                .birthdate(proposal.getBirthDate())
                .build();
    }

    private CarDTO toCarDTO(Proposal proposal) {
        return CarDTO.builder()
                .model(proposal.getModelCar())
                .year(proposal.getModelYear())
                .fipeValue(new BigDecimal(proposal.getFipeValue()))
                .manufacturer(proposal.getManufacturer())
                .build();
    }
}
