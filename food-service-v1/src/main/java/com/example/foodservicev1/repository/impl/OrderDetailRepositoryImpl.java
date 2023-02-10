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
            return jdbcTemplate.query("SELECT\n" +
                            "\tSERVICEORDER.Id,\n" +
                            "\tSERVICEORDER.RestaurantName,\n" +
                            "\tSERVICEORDER.CustomerEmail,\n" +
                            "\tORDERFOOD.FoodName,\n" +
                            "\tORDERFOOD.Price,\n" +
                            "\tORDERFOOD.Quantity,\n" +
                            "\tSERVICEORDER.CreatedDate\n" +
                            "FROM ORDERFOOD\n" +
                            "\tJOIN SERVICEORDER ON SERVICEORDER.Id = ORDERFOOD.OrderId\n" +
                            "WHERE ORDERFOOD.OrderId = ?",
                    new OrderDetailDtoMapper(), orderId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDetailDto> findByRestaurantUsername(String restaurantUsername) {
        try {
            return jdbcTemplate.query("SELECT\n" +
                            "\tSERVICEORDER.Id,\n" +
                            "\tSERVICEORDER.RestaurantName,\n" +
                            "\tSERVICEORDER.CustomerEmail,\n" +
                            "\tORDERFOOD.FoodName,\n" +
                            "\tORDERFOOD.Price,\n" +
                            "\tORDERFOOD.Quantity,\n" +
                            "\tSERVICEORDER.CreatedDate\n" +
                            "FROM ORDERFOOD\n" +
                            "\tJOIN SERVICEORDER ON SERVICEORDER.Id = ORDERFOOD.OrderId\n" +
                            "WHERE SERVICEORDER.RestaurantUsername = ?",
                    new OrderDetailDtoMapper(), restaurantUsername);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OrderDetailDto> findByCustomerEmail(String customerEmail) {
        try {
            return jdbcTemplate.query("SELECT\n" +
                            "\tSERVICEORDER.Id,\n" +
                            "\tSERVICEORDER.RestaurantName,\n" +
                            "\tSERVICEORDER.CustomerEmail,\n" +
                            "\tORDERFOOD.FoodName,\n" +
                            "\tORDERFOOD.Price,\n" +
                            "\tORDERFOOD.Quantity,\n" +
                            "\tSERVICEORDER.CreatedDate\n" +
                            "FROM ORDERFOOD\n" +
                            "\tJOIN SERVICEORDER ON SERVICEORDER.Id = ORDERFOOD.OrderId\n" +
                            "WHERE SERVICEORDER.CustomerEmail = ?",
                    new OrderDetailDtoMapper(), customerEmail);
        } catch (Exception e) {
            return null;
        }
    }
}
