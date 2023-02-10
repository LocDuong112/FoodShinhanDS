package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.OrderFood;
import com.example.foodservicev1.repository.FoodRepository;
import com.example.foodservicev1.repository.OrderFoodRepository;
import com.example.foodservicev1.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Override
    public List<OrderFood> findByOrderId(String orderId) {
        return orderFoodRepository.findByOrderId(orderId);
    }

    @Override
    public int save(OrderFood orderFood) {
        return orderFoodRepository.save(orderFood);
    }

    @Override
    public int deleteByOrderId(String orderId) {
        return orderFoodRepository.deleteByOrderId(orderId);
    }
}
