package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.CartDto;
import com.example.restaurantmanagementjavaspringboot.entity.Cart;

import java.util.List;

public interface CartService {
    public List<CartDto> findAll();

}
