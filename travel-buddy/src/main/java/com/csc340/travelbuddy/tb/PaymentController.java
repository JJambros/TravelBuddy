package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private TripService tripService;

    @GetMapping("/payment")
    public String showPaymentPage(@RequestParam Long tripId, Model model) {
        Trip trip = tripService.getTripById(tripId);  // Use the instance method
        model.addAttribute("trip", trip);
        return "payment";
    }

    @PostMapping("/payment")
    public String processPayment(@RequestParam Long tripId, @RequestParam Long customerId, Model model) {
        // Process the payment here (implementation depends on your payment processing logic)

        // Redirect to the main page with a success message
        model.addAttribute("message", "Thank you for your purchase, enjoy your trip");
        return "redirect:/customers/main?id=" + customerId;
    }
}
