package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;
    ReviewRepository reviewRepository;

    public Object createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Object updateProvider(int id, Provider providerNew) {
        Provider provider = providerRepository.findById(id).orElseThrow();
        provider.setName(providerNew.getName());
        provider.setEmail(providerNew.getEmail());
        provider.setPassword(providerNew.getPassword());
        provider.setMobileNumber(providerNew.getMobileNumber());
        return providerRepository.save(provider);
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

}
