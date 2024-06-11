package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(int id) {
        return tripRepository.findById(id).orElseThrow();
    }

//    public List<Trip> getTripsByCountry(String country) {
//        return tripRepository.findByDestinationContaining(country);
//    }


}
