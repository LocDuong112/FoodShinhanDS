package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> findAll();
    public Customer findByEmail(String email);
    public int save(Customer customer);
    public int update(Customer customer);
    public int delete(String email);
    public int login(String email, String password);
}
