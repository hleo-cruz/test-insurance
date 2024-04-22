package com.audsat.insurance.repository.cars;

import com.audsat.insurance.repository.driver.Driver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARS")
    @SequenceGenerator(name = "SEQ_CARS", sequenceName = "SEQ_CARS", allocationSize = 1)
    private Long id;
    private String model;
    private String manufacturer;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "fipe_value")
    private Double fipeValue;
    @ManyToMany(mappedBy = "cars")
    private List<Driver> drivers;

}
