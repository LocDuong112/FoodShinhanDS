package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.CartMapper;
import com.example.restaurantmanagementjavaspringboot.dto.CartDto;
import com.example.restaurantmanagementjavaspringboot.entity.Cart;
import com.example.restaurantmanagementjavaspringboot.repository.CartRepository;
import com.example.restaurantmanagementjavaspringboot.repository.OrderRepository;
import com.example.restaurantmanagementjavaspringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Resource
    private CartMapper cartMapper;
    @Override
    public List<CartDto> findAll() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> cartDtos = new ArrayList<>();
        for (Cart cart : carts){
            if (Objects.isNull(cart)){
                return null;
            }
            CartDto cartDto = cartMapper.entityToDto(cart);
            cartDtos.add(cartDto);
        }

        return cartDtos;
    }
}
