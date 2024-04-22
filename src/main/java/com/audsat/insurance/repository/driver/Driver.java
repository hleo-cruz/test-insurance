package com.audsat.insurance.repository.driver;

import com.audsat.insurance.repository.cars.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
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
    private Date birthDate;
    @ManyToMany
    @JoinTable(name = "car_drivers", joinColumns = {@JoinColumn(name = "car_id")}, inverseJoinColumns = {@JoinColumn(name = "drivers_id")})
    private List<Car> cars;
}
