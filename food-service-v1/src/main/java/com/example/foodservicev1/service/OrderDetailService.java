package com.example.foodservicev1.service;

import com.example.foodservicev1.dto.OrderDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    public List<OrderDetailDto> findByOrderId(String orderId);
    public List<OrderDetailDto> findByRestaurantUsername(String restaurantUsername);
    public List<OrderDetailDto> findByCustomerEmail(String customerEmail);
}
