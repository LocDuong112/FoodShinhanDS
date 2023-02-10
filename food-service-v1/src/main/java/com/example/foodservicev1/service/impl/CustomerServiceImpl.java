package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.Admin;
import com.example.foodservicev1.entity.Customer;
import com.example.foodservicev1.repository.CustomerRepository;
import com.example.foodservicev1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByEmail(String email) { return customerRepository.findByEmail(email); }

    @Override
    public int save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public int delete(String email) {
        return customerRepository.delete(email);
    }

    @Override
    public int login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            return -1;
        } else if (customer.getPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
}
