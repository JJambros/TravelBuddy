package com.csc340.travelbuddy.tb;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    public Customer() {
    }

    public Customer(int customerId) {
        this.customerId = customerId;
    }
}
