package com.example.exception_handling.service;

import com.example.exception_handling.model.Customer;

public interface CustomerService {

    // Method get Customer by id.
    Customer getCustomer(Long id);

    // Method add a new Customer
    // into database
    String addCustomer(Customer customer);

    // Method to update detail of a Customer
    String updateCustomer(Customer customer);
}
