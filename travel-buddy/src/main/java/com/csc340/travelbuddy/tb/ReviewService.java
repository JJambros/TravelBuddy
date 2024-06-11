package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}
