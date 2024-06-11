package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;
    ReviewRepository reviewRepository;
    TripRepository tripRepository;

    public Object createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider getProviderById(int id) {
        return providerRepository.findById(id).orElse(null);
    }

    public Optional<Provider> findByEmailAndPassword(String email, String password) {
        return providerRepository.findByEmailAndPassword(email, password);
    }

    public Provider updateProvider(Provider provider) {
        providerRepository.save(provider);
        return provider;
    }

    public void deleteProvider(int id) { providerRepository.deleteById(id); }







    public List<Review> getProviderReviews(int id, List<Review> reviews) {
        List<Review> providerReviews = new ArrayList<>();
        for (Review review : reviews) {
            if(id == review.getId()){
                providerReviews.add(review);
            }

        }
        return providerReviews;
    }

    public Object replyReview(long id, Review reviewReply) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setComment(reviewReply.getComment());
        return reviewRepository.save(review);
    }

    public String getCustomerStats(List<Customer> customers) {
        return "You have " + customers.size() + " customers";
    }

    public Object setTripSpecial(int specialid, Trip trip){
        Trip trips = tripRepository.findById(trip.getId()).orElseThrow();
        trip.setSpecialFlag(true);
        return tripRepository.save(trip);
    }

}
