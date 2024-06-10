package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }
}
