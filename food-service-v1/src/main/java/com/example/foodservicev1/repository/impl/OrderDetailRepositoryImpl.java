package com.example.foodservicev1.repository.impl;

import com.example.foodservicev1.dto.OrderDetailDto;
import com.example.foodservicev1.mapper.OrderDetailDtoMapper;
import com.example.foodservicev1.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderDetailDto> findByOrderId(String orderId) {
        try {
            return jdbcTemplate.query("SELECT " +
                            "  SERVICE_ORDER.Id, " +
                            "  SERVICE_ORDER.Restaurant_Name, " +
                            "  SERVICE_ORDER.Customer_Email, " +
                            " ORDER_FOOD.Food_Name, " +
                            " ORDER_FOOD.Price, " +
                            " ORDER_FOOD.Quantity, " +
                            "  SERVICE_ORDER.Created_Date " +
                            "FROM ORDER_FOOD " +
                            " JOIN  SERVICE_ORDER ON  SERVICE_ORDER.Id = ORDER_FOOD.Order_Id " +
                            "WHERE ORDER_FOOD.Order_Id = ?",
                    new OrderDetailDtoMapper(), orderId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDetailDto> findByRestaurantUsername(String restaurantUsername) {
        try {
            return jdbcTemplate.query("SELECT " +
                            "  SERVICE_ORDER.Id, " +
                            "  SERVICE_ORDER.Restaurant_Name, " +
                            "  SERVICE_ORDER.Customer_Email, " +
                            " ORDER_FOOD.Food_Name, " +
                            " ORDER_FOOD.Price, " +
                            " ORDER_FOOD.Quantity, " +
                            "  SERVICE_ORDER.Created_Date " +
                            "FROM ORDER_FOOD " +
                            " JOIN  SERVICE_ORDER ON  SERVICE_ORDER.Id = ORDER_FOOD.Order_Id " +
                            "WHERE  SERVICE_ORDER.Restaurant_Username = ?",
                    new OrderDetailDtoMapper(), restaurantUsername);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDetailDto> findByCustomerEmail(String customerEmail) {
        try {
            return jdbcTemplate.query("SELECT " +
                            "  SERVICE_ORDER.Id, " +
                            "  SERVICE_ORDER.Restaurant_Name, " +
                            "  SERVICE_ORDER.Customer_Email, " +
                            " ORDER_FOOD.Food_Name, " +
                            " ORDER_FOOD.Price, " +
                            " ORDER_FOOD.Quantity, " +
                            "  SERVICE_ORDER.Created_Date " +
                            "FROM ORDER_FOOD " +
                            " JOIN  SERVICE_ORDER ON  SERVICE_ORDER.Id = ORDER_FOOD.Order_Id " +
                            "WHERE  SERVICE_ORDER.Customer_Email = ?",
                    new OrderDetailDtoMapper(), customerEmail);
        } catch (Exception e) {
            return null;
        }
    }
}
