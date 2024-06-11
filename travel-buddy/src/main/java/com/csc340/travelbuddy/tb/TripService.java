package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(int id) {
        return tripRepository.findById(id).orElseThrow();
    }

    public int tripsByProvider(int id) { return tripRepository.countByProviderid(id); }

    public List<Trip> getAllProviderTrips(int id) { return tripRepository.findByProviderid(id); }
}
