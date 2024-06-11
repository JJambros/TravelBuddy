package com.csc340.travelbuddy.tb;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destination;
    private int price;
    private boolean specialFlag;
    private String city;
    private String departure;
    private Date departureDate;
    private Date returnDate;
    private int providerid;
    private int customerId;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany(mappedBy = "trips")
    private List<Customer> customers;

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean isSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(boolean specialFlag) {
        this.specialFlag = specialFlag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}