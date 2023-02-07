package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.entity.Products;
import com.example.restaurantmanagementjavaspringboot.repository.ProductsRepository;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> findProductsByNameByManager(String role, String name) {
        if (role.equals("MANAGER")) {
            return productsRepository.findProductsByName(name);
        }
        return null;
    }

    @Override
    public List<Products> findProductsByNameByCustomer(String role, String name) {
        if (role.equals("CUSTOMER")) {
            return productsRepository.findProductsByName(name);
        }
        return null;
    }

    @Override
    public List<Products> findMostBuyProductsByCustomer(String role) {
        if (role.equals("CUSTOMER")) {
            return productsRepository.findMostBuyProducts();
        }
        return null;
    }


}
