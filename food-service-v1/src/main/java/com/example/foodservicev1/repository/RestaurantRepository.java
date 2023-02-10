package com.example.foodservicev1.repository;

import com.example.foodservicev1.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository {
    public List<Restaurant> findAll();
    public Restaurant findByUsername(String username);
    public int save(Restaurant restaurant);
    public int update(Restaurant restaurant);
    public int delete(String username);
}
