package com.audsat.insurance.repository.customer;

import com.audsat.insurance.dto.request.CustomerRequestDTO;
import com.audsat.insurance.repository.driver.Driver;
import com.audsat.insurance.repository.proposal.Proposal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER")
    @SequenceGenerator(name = "SEQ_CUSTOMER", sequenceName = "SEQ_CUSTOMER", allocationSize = 1)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Customer(CustomerRequestDTO dto, Driver driver) {
        this.name = dto.getCustomerName();
        this.driver = driver;
    }

}
