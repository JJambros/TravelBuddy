package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProviderController {

    @Autowired
    ProviderService providerService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    CustomerService customerService;
    @Autowired
    TripService tripService;

    // Registration views

    @GetMapping("provider/register")
    public String registerForm(){
        return "provider/ProviderSignup";
    }

    @PostMapping("provider/create")
    public String createProvider(Provider provider, Model model) {
        providerService.createProvider(provider);
        model.addAttribute("name", provider.getName());
        model.addAttribute("id", provider.getId());
        return "provider/ProviderSignupSuccess";
    }

    // Login views

    @GetMapping("provider/main/{id}")
    public String loginMain(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/ProviderMain";
    }

    @GetMapping("provider/main/{id}/stats")
    public String providerStats(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/provstats";
    }

    @GetMapping("provider/main/{id}/orders")
    public String providerOrders(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/provorders";
    }

    @GetMapping("provider/main/{id}/reviews")
    public String providerReviews(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/provreviews";
    }

    // Services







    @PutMapping("provider/update/{id}")
    public Object updateProvider(@PathVariable int id, @RequestBody Provider provider) {
        return providerService.updateProvider(id, provider);
    }

    @DeleteMapping("provider/delete/{id}")
    public void deleteProvider(@PathVariable int id) {
        providerService.deleteProvider(id);
    }

    @GetMapping("provider/reviews/{id}")
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

    @PutMapping("provider/specials/{id}/{specialid}")
    public Object setTripSpecial(@PathVariable int id, @PathVariable int specialid){
        return providerService.setTripSpecial(specialid, tripService.getTripById((long) id));
    }

}
