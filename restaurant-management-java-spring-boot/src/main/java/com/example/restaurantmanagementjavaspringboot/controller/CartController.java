package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.CartDto;
import com.example.restaurantmanagementjavaspringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/carts")
    public List<CartDto> findAllCart(){
        return cartService.findAll();
    }
}
