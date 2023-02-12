package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;


import java.util.List;
import java.util.Optional;


public interface OrderService {
    public List<OrderDto> findAll();
    public OrderDto createOrder(OrderDto orderDto);
    public OrderDto findById(long id);
}
