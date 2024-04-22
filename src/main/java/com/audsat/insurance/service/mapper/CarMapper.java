package com.audsat.insurance.service.mapper;

import com.audsat.insurance.dto.request.CarDTO;
import com.audsat.insurance.dto.request.ProposalDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toEntity(CarDTO carDTO) {
        return Car.builder()
                .model(carDTO.getModel())
                .modelYear(carDTO.getYear())
                .fipeValue(carDTO.getFipeValue().doubleValue())
                .manufacturer(carDTO.getManufacturer())
                .build();
    }
}
