package com.audsat.insurance.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class DriverRequestDTO {

    private String document;
    private LocalDate driverBirthDate;
    private Boolean isPrincipalDriver;
}
