package com.audsat.insurance.dto.response;

import com.audsat.insurance.repository.driver.Driver;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class DriverResponseDTO {

    private String document;
    private LocalDate driverBirthDate;
    private Boolean isPrincipalDriver;

    public DriverResponseDTO (Driver driver) {
        this.document = driver.getDocument();
        this.driverBirthDate = driver.getBirthDate();
        this.isPrincipalDriver = driver.getIsMainDriver();
    }
}
