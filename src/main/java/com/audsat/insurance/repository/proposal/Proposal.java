package com.audsat.insurance.repository.proposal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proposal")
public class Proposal {

    @Id
    @SequenceGenerator(name = "SEQ_PROPOSAL", sequenceName = "SEQ_PROPOSAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROPOSAL")
    private Long id;
    @Column(name = "customer_Name")
    private String customerName;
    @Column(name = "document")
    private String document;
    @Column(name = "birthdate")
    private Date birthDate;
    @Column(name = "model_car")
    private String modelCar;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "fipe_value")
    private Double fipeValue;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;
}
