package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.Restaurant;
import com.example.foodservicev1.repository.FoodRepository;
import com.example.foodservicev1.repository.RestaurantRepository;
import com.example.foodservicev1.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findByUsername(String username) { return restaurantRepository.findByUsername(username); }

    @Override
    public int save(Restaurant restaurant) { return restaurantRepository.save(restaurant); }

    @Override
    public int update(Restaurant restaurant) {
        return restaurantRepository.update(restaurant);
    }

    @Override
    public int delete(String username) {
        foodRepository.deleteByRestaurantUsername(username);
        return restaurantRepository.delete(username);
    }

    @Override
    public int login(String username, String password) {
        Restaurant restaurant = restaurantRepository.findByUsername(username);
        if (restaurant == null) {
            return -1;
        } else if (restaurant.getPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
}
