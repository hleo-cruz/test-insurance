package com.audsat.insurance.dto.response;

import com.audsat.insurance.repository.cars.Car;
import lombok.Getter;

@Getter
public class CarResponseDTO {

    private String model;
    private String manufacturer;
    private String year;
    private Double fipeValue;

    public CarResponseDTO(Car car) {
        this.model = car.getModel();
        this.manufacturer = car.getManufacturer();
        this.year = car.getModelYear();
        this.fipeValue = car.getFipeValue();
    }
}
