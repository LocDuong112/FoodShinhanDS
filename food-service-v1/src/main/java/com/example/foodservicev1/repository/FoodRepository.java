package com.example.foodservicev1.repository;


import com.example.foodservicev1.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository {
    public List<Food> findByRestaurantUsername(String restaurantUsername);
    public Food findById(String id);
    public int save(Food food);
    public int update(Food food);
    public int delete(String id);
    public int deleteByRestaurantUsername(String restaurantUsername);
}
