package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "signup";
    }

    @PostMapping("/signup")
    public String createCustomer(@ModelAttribute Customer customer, Model model) {
        Customer savedCustomer = customerService.createCustomer(customer);
        model.addAttribute("customer", savedCustomer);
        return "redirect:/customers/main?id=" + savedCustomer.getId();
    }

    @GetMapping("/main")
    public String showMainPage(@RequestParam Long id, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "MainPage";
        }
        return "redirect:/customers/signup";
    }

    @GetMapping("/profile")
    public String showProfile(@RequestParam Long id, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "Profile";
        }
        return "redirect:/customers/main";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute Customer customer, Model model) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(customer.getId(), customer);
            model.addAttribute("customer", updatedCustomer);
            return "Profile";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "Profile";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/signup";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }
    @PostMapping("/login")
    public String loginCustomer(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<Customer> customerOpt = customerService.findByEmailAndPassword(email, password);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            model.addAttribute("customer", customer);
            return "redirect:/customers/main?id=" + customer.getId();
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}