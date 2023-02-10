package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;


import java.util.List;


public interface OrderService {
    public List<OrderDto> findAll();
    public OrderDto createOrder(OrderDto orderDto);
}
