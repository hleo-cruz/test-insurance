package com.audsat.insurance.repository.insurance;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cars")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSURANCE")
    @SequenceGenerator(name = "SEQ_INSURANCE", sequenceName = "SEQ_INSURANCE", allocationSize = 1)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "creation_dt")
    private Date creationDate;
    @Column(name = "updated_at")
    private Date upadtedDate;
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "is_active")
    private Boolean isActive;
}
