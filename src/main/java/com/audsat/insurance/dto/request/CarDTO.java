package com.audsat.insurance.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String model;
    private String manufacturer;
    private String year;
    private BigDecimal fipeValue;
}
