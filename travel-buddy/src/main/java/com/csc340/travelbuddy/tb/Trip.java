package com.csc340.travelbuddy.tb;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String destination;
    private int price;
    private boolean specialFlag;
    private String city;
    private String departure;
    private Date departuredate;
    private Date returndate;
    private int providerid;
    private int customerId;


    public Trip() {
    }

    public Trip(int id, String destination, int price, boolean specialFlag, String city, String departure, Date departuredate, Date returndate, int providerid, int customerId) {
        this.id = id;
        this.destination = destination;
        this.price = price;
        this.specialFlag = specialFlag;
        this.city = city;
        this.departure = departure;
        this.departuredate = departuredate;
        this.returndate = returndate;
        this.providerid = providerid;
        this.customerId = customerId;
    }


    public boolean isSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(boolean specialFlag) {
        this.specialFlag = specialFlag;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
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