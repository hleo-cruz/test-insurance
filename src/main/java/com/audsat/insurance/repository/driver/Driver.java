package com.audsat.insurance.repository.driver;

import com.audsat.insurance.dto.request.DriverRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DRIVER")
    @SequenceGenerator(name = "SEQ_DRIVER", sequenceName = "SEQ_DRIVER", allocationSize = 1)
    private Long id;
    private String document;
    @Column(name = "driver_birth_date")
    private Date birthDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_drivers", joinColumns = {@JoinColumn(name = "driver_id")}, inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars;

    public Driver(DriverRequestDTO driverDTO, Car cars) {
        this.document = driverDTO.getDocument();
        this.birthDate = driverDTO.getDriverBirthDate();
        this.cars = Arrays.asList(cars);
    }
}
