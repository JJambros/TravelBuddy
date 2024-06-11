package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/write")
    public String showReviewForm(@RequestParam Long customerId, @RequestParam Long tripId, Model model) {
        Review review = new Review();
        model.addAttribute("review", review);
        model.addAttribute("customerId", customerId);
        model.addAttribute("tripId", tripId);
        return "write-review";
    }

    @PostMapping("/write")
    public String submitReview(@ModelAttribute Review review, @RequestParam int customerId, @RequestParam int tripId, Model model) {
        Customer customer = new Customer();
        customer.setId(customerId);
        Trip trip = new Trip();
        trip.setId(tripId);
        review.setCustomer(customer);
        review.setTrip(trip);
        reviewService.createReview(review);
        return "redirect:/customers/profile?id=" + customerId;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

//    @GetMapping("/trip/{tripId}")
//    public List<Review> getReviewsByTripId(@PathVariable Long tripId) {
//        return reviewService.getReviewsByTripId(tripId);
//    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
