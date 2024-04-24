package com.audsat.insurance.repository.driverCar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverCarRepository extends JpaRepository<DriverCar, Long> {

    DriverCar findByCarIdAndAndDriverId(Long carId, Long driverId);

}
