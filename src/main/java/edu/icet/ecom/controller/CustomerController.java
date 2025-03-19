package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Customer;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        boolean isAdded = customerService.addCustomer(customer);
        if (isAdded) {
            return "Customer added successfully!";
        } else {
            return "Failed to add customer.";
        }
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        boolean isUpdated = customerService.updateCustomer(customer, id);
        if (isUpdated) {
            return "Customer updated successfully!";
        } else {
            return "Failed to update customer.";
        }
    }

    @GetMapping("/get-all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        if (isDeleted) {
            return "Customer deleted successfully!";
        } else {
            return "Failed to delete customer.";
        }
    }

    @GetMapping("/get/{id}")
    public Customer searchCustomer(@PathVariable Integer id) {
        return customerService.searchCustomer(id);
    }



}
