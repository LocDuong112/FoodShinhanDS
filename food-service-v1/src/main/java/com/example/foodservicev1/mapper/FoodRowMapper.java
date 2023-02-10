package com.example.foodservicev1.mapper;

import com.example.foodservicev1.entity.Food;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodRowMapper implements RowMapper<Food> {

    @Override
    public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
        Food food = new Food();
        food.setId(rs.getString("Id"));
        food.setRestaurantUsername(rs.getString("RestaurantUsername"));
        food.setName(rs.getString("Name"));
        food.setPrice(rs.getDouble("Price"));
        food.setImageLink(rs.getString("ImageLink"));
        return food;
    }
}
