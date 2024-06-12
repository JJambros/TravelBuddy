package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/write")
    public String showReviewForm(@RequestParam int customerId, @RequestParam int tripId, Model model) {
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

    @GetMapping("/list")
    public String listReviews(@RequestParam int customerId, Model model) {
        List<Review> reviews = reviewService.getReviewsByCustomerId(customerId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("customerId", customerId);
        return "list-reviews";
    }

    @GetMapping("/edit")
    public String showEditReviewForm(@RequestParam int reviewId, Model model) {
        Optional<Review> reviewOpt = reviewService.getReviewById(reviewId);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            model.addAttribute("review", review);
            model.addAttribute("customerId", review.getCustomer().getId());
            model.addAttribute("tripId", review.getTrip().getId());
            return "edit-review";
        }
        return "redirect:/reviews/list";
    }

    @PostMapping("/edit")
    public String submitEditReview(@ModelAttribute Review review, Model model) {
        Optional<Review> existingReviewOpt = reviewService.getReviewById(review.getId());
        if (existingReviewOpt.isPresent()) {
            Review existingReview = existingReviewOpt.get();
            existingReview.setComment(review.getComment());
            existingReview.setRating(review.getRating());
            reviewService.updateReview(existingReview.getId(), existingReview);
            return "redirect:/reviews/list?customerId=" + existingReview.getCustomer().getId();
        }
        return "redirect:/reviews/list";
    }

    @PostMapping("/delete")
    public String deleteReview(@RequestParam int reviewId) {
        Optional<Review> reviewOpt = reviewService.getReviewById(reviewId);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            int customerId = review.getCustomer().getId();
            reviewService.deleteReview(reviewId);
            return "redirect:/reviews/list?customerId=" + customerId;
        }
        return "redirect:/reviews/list";
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/trip/{tripId}")
    public List<Review> getReviewsByTripId(@PathVariable int tripId) {
        return reviewService.getReviewsByTripId(tripId);
    }
}