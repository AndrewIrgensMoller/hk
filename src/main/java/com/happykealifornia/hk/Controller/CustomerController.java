package com.happykealifornia.hk.Controller;

import com.happykealifornia.hk.Model.Customer;
import com.happykealifornia.hk.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping ("/add-customer")
    public String newCustomer(Model m) {
        m.addAttribute("newCustomer", new Customer());
        return "/customer";
    }

    @PostMapping("/add-customer/save")
    public String saveTCustomer(@ModelAttribute Customer customer) {
        customerRepo.newCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer")
    public String showCustomers(Model model) {
        List<Customer> customerList = customerRepo.findCustomer();
        model.addAttribute("customer", customerList);
        return "/customer";
    }


}
