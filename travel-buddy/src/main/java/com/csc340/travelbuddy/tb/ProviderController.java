package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    @Autowired
    ServicesService servicesService;


    // Registration views

    @GetMapping("provider/register")
    public String registerForm(){
        return "provider/ProviderSignup";
    }

    @GetMapping("provider/login")
    public String loginForm(Model model){
        model.addAttribute("provider", new Provider());
        return "provider/ProviderLogin";
    }

    @PostMapping("provider/login")
    public String loginProvider(@RequestParam String email, @RequestParam String password, Model model){
        Optional<Provider> providerOpt = providerService.findByEmailAndPassword(email, password);
        if (providerOpt.isPresent()) {
            Provider provider = providerOpt.get();
            model.addAttribute("provider", provider);
            return "redirect:/provider/main/" + provider.getId();
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "provider/ProviderLogin";
        }
    }

    @PostMapping("provider/create")
    public String createProvider(Provider provider, Model model) {
        providerService.createProvider(provider);
        model.addAttribute("name", provider.getName());
        model.addAttribute("id", provider.getId());
        return "provider/ProviderSignupSuccess";
    }

    @GetMapping("provider/delete")
    public String deleteProvider(@RequestParam int id) {
        providerService.deleteProvider(id);
        return "provider/ProviderSignup";
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
        model.addAttribute("totalUsers", customerService.getUserCount());
        model.addAttribute("totalServices", servicesService.servicesByProvider(id));
        model.addAttribute("totalBooked", tripService.tripsByProvider(id));
        return "provider/provstats";
    }

    @GetMapping("provider/main/{id}/orders")
    public String providerOrders(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        model.addAttribute("tripList", tripService.getAllProviderTrips(id));
        return "provider/provorders";
    }

    @GetMapping("provider/main/{id}/reviews")
    public String providerReviews(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        model.addAttribute("reviewList", reviewService.getReviewsByProviderId(id));
        return "provider/provreviews";
    }

    @GetMapping("provider/main/{id}/reviews/response")
    public String providerReviewReply(@PathVariable int id, @RequestParam int reviewId, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        Optional<Review> reviewOpt = reviewService.getReviewById(reviewId);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            model.addAttribute("review", review);
            return "provider/ProviderReviewReply";
        } else {
            model.addAttribute("error", "Invalid review");
            return "provider/ProviderLogin";
        }
    }

    @GetMapping("provider/main/{id}/profile")
    public String showProviderProfile(@PathVariable int id, Model model){
        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/ProviderProfile";
    }

    @PostMapping("provider/main/{id}/profile")
    public String updateProviderProfile(@ModelAttribute Provider provider, @PathVariable int id, Model model){
        try {
            Provider updatedProvider = providerService.updateProvider(provider);
            model.addAttribute("provider", updatedProvider);
            return "redirect:/provider/main/" + provider.getId();
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/provider/main/" + provider.getId();
        }
    }


    // Services




}
