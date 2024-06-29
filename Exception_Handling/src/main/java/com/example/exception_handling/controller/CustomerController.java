package com.example.exception_handling.controller;


import com.example.exception_handling.exception.CustomerAlreadyExistsException;
import com.example.exception_handling.exception.ErrorResponse;
import com.example.exception_handling.model.Customer;
import com.example.exception_handling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Get Customer by Id
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id)
    {
        return customerService.getCustomer(id);
    }

    // Add new Customer
    @PostMapping("/addCustomer")
    public String
    addcustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }

    // Update Customer details
    @PutMapping("/updateCustomer")
    public String
    updateCustomer(@RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }

    // handling exception
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
    }
}
