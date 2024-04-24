package com.audsat.insurance.dto.request;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public class CarRequestDTO {

    private String model;
    private String manufacturer;
    private String year;
    private Double fipeValue;
}
