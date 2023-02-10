package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.dto.OrderDetailDto;
import com.example.foodservicev1.repository.OrderDetailRepository;
import com.example.foodservicev1.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDto> findByOrderId(String orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderDetailDto> findByRestaurantUsername(String restaurantUsername) {
        return orderDetailRepository.findByRestaurantUsername(restaurantUsername);
    }

    @Override
    public List<OrderDetailDto> findByCustomerEmail(String customerEmail) {
        return orderDetailRepository.findByCustomerEmail(customerEmail);
    }
}
