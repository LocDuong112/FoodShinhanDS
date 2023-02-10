package com.example.restaurantmanagementjavaspringboot.service;


import com.example.restaurantmanagementjavaspringboot.entity.Cart;
import com.example.restaurantmanagementjavaspringboot.entity.Products;

public interface ProductCartService {
    public void deleteByCartAndProduct(Cart cart, Products product);
}
