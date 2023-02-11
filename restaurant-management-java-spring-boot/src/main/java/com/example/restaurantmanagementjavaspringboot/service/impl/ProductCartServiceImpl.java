package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.entity.Cart;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import com.example.restaurantmanagementjavaspringboot.repository.ProductCartRepository;
import com.example.restaurantmanagementjavaspringboot.service.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCartServiceImpl implements ProductCartService {

    @Autowired
    private ProductCartRepository productCartRepository;
    @Override
    public void deleteByCartAndProduct(Cart cart, Products product) {
        productCartRepository.deleteByCartAndProducts(cart, product);
    }
}
