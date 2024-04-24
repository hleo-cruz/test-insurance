package com.audsat.insurance.repository.driverCar;

import com.audsat.insurance.dto.request.DriverRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car_drivers")
public class DriverCar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAR_DRIVER")
    @SequenceGenerator(name = "SEQ_CAR_DRIVER", sequenceName = "SEQ_CAR_DRIVER", allocationSize = 1)
    private Long id;
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "is_main_driver")
    private Boolean isPrincipalDriver;

    public void markPrincipalDriver() {
        this.isPrincipalDriver = true;
    }
}
