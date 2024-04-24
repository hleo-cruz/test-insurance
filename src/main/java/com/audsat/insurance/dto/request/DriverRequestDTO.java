package com.audsat.insurance.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class DriverRequestDTO {

    private String document;
    private Date driverBirthDate;
    private Boolean isPrincipalDriver;
}
