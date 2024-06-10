package com.csc340.travelbuddy.tb;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;

    @ManyToMany
    @JoinTable(
            name = "customer_trip",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private List<Trip> trips;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public List<Trip> getTrips() {
        return trips;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Review> getReviews() {
        return reviews;

    }
}
