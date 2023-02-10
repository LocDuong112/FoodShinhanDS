package com.example.foodservicev1.mapper;

import com.example.foodservicev1.entity.ServiceOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ServiceOrderRowMapper implements RowMapper<ServiceOrder> {
    @Override
    public ServiceOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setId(rs.getString("Id"));
        serviceOrder.setRestaurantUsername(rs.getString("RestaurantUsername"));
        serviceOrder.setRestaurantName(rs.getString("RestaurantName"));
        serviceOrder.setCustomerEmail(rs.getString("CustomerEmail"));
        serviceOrder.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return serviceOrder;
    }
}
