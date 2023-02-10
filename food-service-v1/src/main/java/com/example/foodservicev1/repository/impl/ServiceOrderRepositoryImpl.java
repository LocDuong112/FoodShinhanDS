package com.example.foodservicev1.repository.impl;

import com.example.foodservicev1.entity.ServiceOrder;
import com.example.foodservicev1.mapper.ServiceOrderRowMapper;
import com.example.foodservicev1.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceOrderRepositoryImpl implements ServiceOrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ServiceOrder> find() {
        try {
            return jdbcTemplate.query("SELECT * FROM SERVICEORDER", new ServiceOrderRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ServiceOrder> findByRestaurantUsername(String restaurantUsername) {
        try {
            return jdbcTemplate.query("SELECT * FROM SERVICEORDER WHERE RestaurantUsername = ?",
                    new ServiceOrderRowMapper(), restaurantUsername);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ServiceOrder> findByCustomerEmail(String customerEmail) {
        try {
            return jdbcTemplate.query("SELECT * FROM SERVICEORDER WHERE CustomerEmail = ?",
                    new ServiceOrderRowMapper(), customerEmail);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ServiceOrder findById(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SERVICEORDER WHERE Id = ?", new ServiceOrderRowMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int save(ServiceOrder serviceOrder) {
        try {
            return jdbcTemplate.update(
                    "INSERT INTO SERVICEORDER ( Id, RestaurantUsername, RestaurantName, CustomerEmail, CreatedDate )" +
                            "VALUES ( ?, ?, ?, ?, CURRENT_DATE )",
                    new Object[]{serviceOrder.getId(), serviceOrder.getRestaurantUsername(),
                            serviceOrder.getRestaurantName(), serviceOrder.getCustomerEmail()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(ServiceOrder serviceOrder) {
        return 0;
    }

    @Override
    public int delete(String id) {
        try {
            return jdbcTemplate.update("DELETE FROM SERVICEORDER WHERE Id = ?", id);
        } catch (Exception e) {
            return 0;
        }
    }
}
