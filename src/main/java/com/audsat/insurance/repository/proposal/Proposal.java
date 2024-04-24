package com.audsat.insurance.repository.proposal;

import com.audsat.insurance.dto.request.CarRequestDTO;
import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.dto.request.ProposalRequestDTO;
import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    @Column(name = "is_active")
    private Boolean isActive;

    public Proposal(List<Customer> customers, Car car) {
        this.customers = customers;
        this.car = car;
        this.isActive = true;
    }
}
