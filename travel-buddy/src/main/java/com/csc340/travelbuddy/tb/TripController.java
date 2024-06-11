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
        Trip trip = tripService.getTripById(tripId);
        Customer customer = customerService.getCustomerById(customerId).orElseThrow();

        model.addAttribute("trip", trip);
        model.addAttribute("customer", customer);

        return "Payment";
    }
}