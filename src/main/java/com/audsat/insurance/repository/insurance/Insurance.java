package com.audsat.insurance.repository.insurance;

import com.audsat.insurance.repository.cars.Car;
import com.audsat.insurance.repository.customer.Customer;
import com.audsat.insurance.repository.proposal.Proposal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "insurance")
public class Insurance {

    @Id
    private UUID id;
    @OneToMany
    private List<Customer> customers;
    @Column(name = "creation_dt")
    private Date creationDate;
    @Column(name = "updated_at")
    private Date upadtedDate;
    @OneToOne
    private Car car;
    @Column(name = "is_active")
    private Boolean isActive;
    private BigDecimal cost;

    public Insurance(Proposal proposal, BigDecimal cost) {
        this.id = proposal.getId();
        this.customers = proposal.getCustomers();
        this.car = proposal.getCar();
        this.isActive = false;
        this.cost = cost;
    }
}
