package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Review> getReviewsByProviderId(int providerId) {
        List<Review> providerReviews = new ArrayList<>();
        List<Review> allReviews = reviewRepository.findAll();
        for(Review review : allReviews) {
            if(review.getTrip().getProviderid() == providerId) {
                providerReviews.add(review);
            }
        }
        return providerReviews;
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }
}
