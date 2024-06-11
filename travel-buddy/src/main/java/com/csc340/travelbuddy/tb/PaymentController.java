package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private TripService tripService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/Payment")
    public String processPayment(@RequestParam Long tripId, @RequestParam Long customerId, Model model) {
        // Process the payment here (implementation depends on your payment processing logic)

        // Fetch the trip and customer
        Trip trip = tripService.getTripById(tripId);
        Customer customer = customerService.getCustomerById(customerId).orElseThrow();

        // Add trip to customer's trips
        customer.getTrips().add(trip);
        customerService.updateCustomer(customer.getId(), customer);

        // Redirect to the main page with a success message
        model.addAttribute("message", "Thank you for your purchase, enjoy your trip");
        return "redirect:/customers/main?id=" + customerId;
    }
}
