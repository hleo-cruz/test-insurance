package com.audsat.insurance.repository.claim;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLAIM")
    @SequenceGenerator(name = "SEQ_CLAIM", sequenceName = "SEQ_CLAIM", allocationSize = 1)
    private Long id;
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "event_date")
    private Date eventDate;
}
