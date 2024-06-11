package com.csc340.travelbuddy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "/index"})
    public String home(){
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
