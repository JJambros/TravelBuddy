package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;
    ReviewService reviewService;
    CustomerService customerService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("provider/create")
    public Object createProvider(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    @PutMapping("provider/update/{id}")
    public Object updateProvider(@PathVariable int id, @RequestBody Provider provider) {
        return providerService.updateProvider(id, provider);
    }

    @DeleteMapping("provider/delete/{id}")
    public void deleteProvider(@PathVariable int id) {
        providerService.deleteProvider(id);
    }

    @GetMapping("provider/reviews{id}")
    public List<Review> getProviderReviews(@PathVariable int id) {
        return providerService.getProviderReviews(id, reviewService.getAllReviews());
    }

    @PutMapping("provider/reviews/{id}")
    public Object replyReview(@PathVariable int id, @RequestBody Review review) {
        return providerService.replyReview(id, review);
    }

    @GetMapping("provider/stats")
    public String getCustomerStats(){
        return providerService.getCustomerStats(customerService.getAllCustomers());
    }
}
