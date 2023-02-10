package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.Food;
import com.example.foodservicev1.repository.FoodRepository;
import com.example.foodservicev1.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findByRestaurantUsername(String restaurantUsername) {
        return foodRepository.findByRestaurantUsername(restaurantUsername);
    }

    @Override
    public Food findById(String id) {
        return foodRepository.findById(id);
    }

    @Override
    public int save(Food food) {
        food.setId(UUID.randomUUID().toString());
        return foodRepository.save(food);
    }

    @Override
    public int update(Food food) { return foodRepository.update(food); }

    @Override
    public int delete(String id) {
        return foodRepository.delete(id);
    }

    @Override
    public int deleteByRestaurantUsername(String restaurantUsername) {
        return foodRepository.deleteByRestaurantUsername(restaurantUsername);
    }
}
