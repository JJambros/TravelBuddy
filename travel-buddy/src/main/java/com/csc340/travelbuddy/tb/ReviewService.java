package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByTripId(int tripId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getTrip().getId() == tripId)
                .toList();
    }

    public Optional<Review> getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> getReviewsByCustomerId(int customerId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getCustomer().getId() == customerId)
                .toList();
    }

    public Review updateReview(int reviewId, Review reviewDetails) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewId));
        review.setComment(reviewDetails.getComment());
        review.setRating(reviewDetails.getRating());
        return reviewRepository.save(review);
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}