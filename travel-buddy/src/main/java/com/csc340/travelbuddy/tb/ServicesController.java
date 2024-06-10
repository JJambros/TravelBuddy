package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicesController {

    @Autowired
    ServicesService servicesService;

    @GetMapping("/provider/main/{id}/services")
    public String getAllGoals(@PathVariable int id,Model model) {
        model.addAttribute("servicesList", servicesService.getAllServices());
        return "/provider/provservices";
    }

    @PostMapping("/services/create")
    public String addNewService(Services services) {
        servicesService.addNewService(services);
        int id = services.getProviderid();
        String url = "redirect:/provider/main/" + id + "/services";
        return url;
    }
}
