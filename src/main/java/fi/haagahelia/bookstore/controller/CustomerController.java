package fi.haagahelia.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookstore.model.Customer;
import fi.haagahelia.bookstore.model.CustomerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customerlist")
    public String customerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerlist";

    
    }
    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    @PostMapping("/savecustomer")
    public String save(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customerlist";
    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
    customerRepository.deleteById(id);
    return "redirect:/customerlist";
    }

    @GetMapping("/editcustomer/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
    Customer customer = customerRepository.findById(id).orElse(null);
    model.addAttribute("customer", customer);
    return "addcustomer";
    }
}

