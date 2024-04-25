package com.audsat.insurance.repository.driver;

import com.audsat.insurance.dto.request.DriverRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
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
    private LocalDate birthDate;
    @Column(name = "is_main_driver")
    private Boolean isMainDriver;

    public Driver(DriverRequestDTO driverDTO) {
        this.document = driverDTO.getDocument();
        this.birthDate = driverDTO.getDriverBirthDate();
        this.isMainDriver = driverDTO.getIsPrincipalDriver();
    }
}
