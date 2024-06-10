package com.csc340.travelbuddy.tb;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String description;
    private Double price;

    public boolean isSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(boolean specialFlag) {
        this.specialFlag = specialFlag;
    }

    private boolean specialFlag;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @ManyToMany(mappedBy = "trips")
    private List<Customer> customers;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}