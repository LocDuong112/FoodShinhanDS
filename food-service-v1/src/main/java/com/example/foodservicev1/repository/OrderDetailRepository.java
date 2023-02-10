package com.example.foodservicev1.repository;

import com.example.foodservicev1.dto.OrderDetailDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository {
    public List<OrderDetailDto> findByOrderId(String orderId);
    public List<OrderDetailDto> findByRestaurantUsername(String restaurantUsername);
    public List<OrderDetailDto> findByCustomerEmail(String customerEmail);
}
