package com.example.foodservicev1.repository.impl;

import com.example.foodservicev1.entity.OrderFood;
import com.example.foodservicev1.mapper.FoodRowMapper;
import com.example.foodservicev1.mapper.OrderFoodRowMapper;
import com.example.foodservicev1.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderFoodRepositoryImpl implements OrderFoodRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderFood> findByOrderId(String orderId) {
        try {
            return jdbcTemplate.query("SELECT * FROM ORDERFOOD WHERE OrderId = ?",
                    new OrderFoodRowMapper(), orderId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int save(OrderFood orderFood) {
        try {
            return jdbcTemplate.update("INSERT INTO ORDERFOOD ( OrderId, FoodId, FoodName, Quantity, Price )" +
                            "VALUES ( ?, ?, ?, ?, ? )",
                    new Object[]{orderFood.getOrderId(), orderFood.getFoodId(),
                            orderFood.getFoodName(), orderFood.getQuantity(), orderFood.getPrice()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteByOrderId(String orderId) {
        try {
            return jdbcTemplate.update("DELETE FROM FOOD WHERE OrderId = ?", orderId);
        } catch (Exception e) {
            return 0;
        }
    }
}
