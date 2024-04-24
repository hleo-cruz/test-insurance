package com.audsat.insurance.service;

import com.audsat.insurance.repository.driverCar.DriverCar;
import com.audsat.insurance.repository.driverCar.DriverCarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverCarService {

    @Autowired
    private DriverCarRepository repository;

    @Transactional
    public void markMainDriver(Long carId, Long driverId) {
        final DriverCar driverCar = repository.findByCarIdAndAndDriverId(carId, driverId);
        driverCar.markPrincipalDriver();
    }
}
