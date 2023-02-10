package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    public List<Restaurant> findAll();
    public Restaurant findByUsername(String username);
    public int save(Restaurant restaurant);
    public int update(Restaurant restaurant);
    public int delete(String username);
    public int login(String email, String password);
}
