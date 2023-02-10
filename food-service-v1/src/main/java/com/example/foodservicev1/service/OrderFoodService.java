package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.OrderFood;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderFoodService {
    public List<OrderFood> findByOrderId(String orderId);
    public int save(OrderFood orderFood);
    public int deleteByOrderId(String orderId);
}
