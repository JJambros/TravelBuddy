package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServicesService servicesService;

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable int id) {
        return tripService.getTripById(id);
    }

    @PostMapping("/book-trip")
    public String bookTrip(@RequestParam int customerId, @RequestParam int tripId, Model model) {
        Optional<Services> serviceOptional = servicesService.findById(tripId);
        if (serviceOptional.isPresent()) {
            Services service = serviceOptional.get();
            Trip trip = new Trip();
            trip.setPrice(service.getPrice());
            trip.setDestination(service.getLocation());
            trip.setCity(service.getCity());
            trip.setSpecialFlag(service.isSpecials());
            trip.setDeparture(service.getDeparture());
            trip.setDepartureDate(service.getDeparturedate());
            trip.setReturnDate(service.getReturndate());
            trip.setProviderid(service.getProviderid());
            trip.setCustomerId(customerId);
            tripService.createTrip(trip);
            model.addAttribute("trip", trip);
        }
        return "Payment";
    }