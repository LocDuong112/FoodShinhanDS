package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    public List<Food> findByRestaurantUsername(String restaurantUsername);
    public Food findById(String id);
    public int save(Food food);
    public int update(Food food);
    public int delete(String id);
    public int deleteByRestaurantUsername(String restaurantUsername);
}
