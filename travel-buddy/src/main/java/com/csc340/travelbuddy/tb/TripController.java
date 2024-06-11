package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private ServicesService servicesService;
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
            model.addAttribute("customerId", customerId);
            model.addAttribute("trip", trip);
        }
        return "Payment";
    }

    @PostMapping("/Payment")
    public String processPayment(
            @RequestParam("tripId") int tripId,
            @RequestParam("customerId") int customerId,
            @RequestParam("card-name") String cardName,
            @RequestParam("card-number") String cardNumber,
            @RequestParam("expiry-date") String expiryDate,
            @RequestParam("cvv") String cvv,
            @RequestParam("billing-address") String billingAddress,
            @RequestParam("zipcode") String zipcode,
            Model model) {

        System.out.println("Processing payment for tripId: " + tripId + " and customerId: " + customerId);

        Trip trip = tripService.getTripById(tripId);
        Customer customer = customerService.getCustomerById(customerId).orElseThrow();

        customer.getTrips().add(trip);
        customerService.updateCustomer(customer.getId(), customer);

        model.addAttribute("message", "Thank you for your purchase, enjoy your trip");
        return "redirect:/customers/main?id=" + customerId;
    }
}