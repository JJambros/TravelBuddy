package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ServicesController {

    @Autowired
    ServicesService servicesService;

    @GetMapping("/provider/main/{id}/services")
    public String getAllServices(@PathVariable int id, Model model) {
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

    @GetMapping("/services/service-info")
    public String createServiceForm(@RequestParam("id") int id, Model model) {
        Optional<Services> serviceOptional = servicesService.findById(id);
        if (serviceOptional.isPresent()) {
            Services service = serviceOptional.get();
            model.addAttribute("service", service);
        }
        model.addAttribute("servicesList", servicesService.getAllServices());
        return "provider/service-info";
    }

    @PostMapping("/services/update-service")
    public String updateService(Services services) {
        servicesService.updateService(services);
        int id = services.getProviderid();
        String url = "redirect:/provider/main/" + id + "/services";
        return url;
    }
}
