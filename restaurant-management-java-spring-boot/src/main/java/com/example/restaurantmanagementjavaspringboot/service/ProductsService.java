package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    public List<Products> findProductsByNameByManager(String role, String name);
    public List<Products> findMostBuyProductsByCustomer(String role);
    public List<Products> findProductsByNameByCustomer(String role, String name);
}
