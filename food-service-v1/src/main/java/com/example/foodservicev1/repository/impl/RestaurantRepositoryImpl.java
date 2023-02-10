package com.example.foodservicev1.repository.impl;

import com.example.foodservicev1.entity.Restaurant;
import com.example.foodservicev1.mapper.AdminRowMapper;
import com.example.foodservicev1.mapper.RestaurantRowMapper;
import com.example.foodservicev1.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Restaurant> findAll() {
        return jdbcTemplate.query("SELECT * FROM RESTAURANT", new RestaurantRowMapper());
    }

    @Override
    public Restaurant findByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM RESTAURANT WHERE Username = ?",
                    new RestaurantRowMapper(), username);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int save(Restaurant restaurant) {
        try {
            return jdbcTemplate.update("INSERT INTO RESTAURANT ( Username, Name, Email, Password, ImageLink, Address )" +
                            "VALUES ( ?, ?, ?, ?, ?, ? )",
                    new Object[]{restaurant.getUsername(), restaurant.getName(), restaurant.getEmail(),
                            restaurant.getPassword(), restaurant.getImageLink(), restaurant.getAddress()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(Restaurant restaurant) {
        try {
            return jdbcTemplate.update("UPDATE RESTAURANT SET " +
                            "Name = ?, Password = ?, ImageLink = ?, Address = ? WHERE Username = ?",
                    new Object[]{restaurant.getName(), restaurant.getPassword(),
                            restaurant.getImageLink(), restaurant.getAddress(), restaurant.getUsername()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String username) {
        try {
            return jdbcTemplate.update("DELETE FROM RESTAURANT WHERE Username = ?", username);
        } catch (Exception e) {
            return 0;
        }
    }
}
