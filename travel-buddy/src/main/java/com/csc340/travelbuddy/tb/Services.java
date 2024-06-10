package com.csc340.travelbuddy.tb;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Nonnull
    private String location;
    private int providerid;
    private String departure;
    private int price;
    private Date departuredate;
    private Date returndate;
    private boolean specials;

    public Services(int id, @Nonnull String location, int providerid, String departure, int price, Date departuredate, Date returndate, boolean specials) {
        this.id = id;
        this.location = location;
        this.providerid = providerid;
        this.departure = departure;
        this.price = price;
        this.departuredate = departuredate;
        this.returndate = returndate;
        this.specials = specials;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    public Services() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nonnull
    public String getLocation() {
        return location;
    }

    public void setLocation(@Nonnull String location) {
        this.location = location;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public boolean isSpecials() {
        return specials;
    }

    public void setSpecials(boolean specials) {
        this.specials = specials;
    }
}
