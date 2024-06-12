package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ResponseController {

    @Autowired
    private ResponseService responseService;
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/response")
    public String reviewResponse(@RequestParam String response, @RequestParam int reviewId, @RequestParam int providerId){
        Optional<Review> reviewOptional = reviewService.getReviewById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            Response responseNew = new Response();
            responseNew.setResponse(response);
            responseNew.setReview(review);
            responseService.createResponse(responseNew);
            return "redirect:/provider/main/" + providerId;
        } else {
            return "redirect:/provider/main" + providerId;
        }
    }
}
