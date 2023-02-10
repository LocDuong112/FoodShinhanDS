package com.example.foodservicev1.repository;

import com.example.foodservicev1.entity.Food;
import com.example.foodservicev1.entity.OrderFood;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFoodRepository {
    public List<OrderFood> findByOrderId(String orderId);
    public int save(OrderFood orderFood);
    public int deleteByOrderId(String orderId);
}
