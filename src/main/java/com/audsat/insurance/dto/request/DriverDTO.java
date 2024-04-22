package com.audsat.insurance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private String document;
    private Date birthdate;
    private Boolean fgMainDriver;
}
