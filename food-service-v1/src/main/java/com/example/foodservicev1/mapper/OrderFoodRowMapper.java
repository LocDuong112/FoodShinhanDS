package com.example.foodservicev1.mapper;

import com.example.foodservicev1.entity.Food;
import com.example.foodservicev1.entity.OrderFood;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderFoodRowMapper implements RowMapper<OrderFood> {
    @Override
    public OrderFood mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderFood orderFood = new OrderFood();
        orderFood.setOrderId(rs.getString("OrderId"));
        orderFood.setFoodId(rs.getString("FoodId"));
        orderFood.setFoodName(rs.getString("FoodName"));
        orderFood.setQuantity(rs.getInt("Quantity"));
        orderFood.setPrice(rs.getDouble("Price"));
        return orderFood;
    }
}
