package com.example.exception_handling.service;

import com.example.exception_handling.exception.CustomerAlreadyExistsException;
import com.example.exception_handling.exception.NoSuchCustomerExistsException;
import com.example.exception_handling.model.Customer;
import com.example.exception_handling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Method to get customer by Id.Throws
    // NoSuchElementException for invalid Id
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new NoSuchCustomerExistsException("NO CUSTOMER WITH ID=" + id));
    }


    // Method to add new customer details to database.Throws
    // CustomerAlreadyExistsException when customer detail
    // already exist
    @Override
    public String addCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (existingCustomer == null) {
            customerRepository.save(customer);
            return "Customer added Successful";
        } else {
            throw new CustomerAlreadyExistsException("Customer already exists!!");
        }

    }


    // Method to update customer details to database.Throws
    // NoSuchCustomerExistsException when customer doesn't
    // already exist in database
    @Override
    public String updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (existingCustomer == null) {
            throw new NoSuchCustomerExistsException("No Such Customer exists");
        } else {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            customerRepository.save(existingCustomer);
            return "Record updated Successfully";
        }
    }
}
