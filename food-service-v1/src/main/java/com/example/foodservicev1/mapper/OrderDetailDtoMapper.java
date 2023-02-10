package com.example.foodservicev1.mapper;


import com.example.foodservicev1.dto.OrderDetailDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDtoMapper implements RowMapper<OrderDetailDto> {
    @Override
    public OrderDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setId(rs.getString("Id"));
        orderDetailDto.setRestaurantName(rs.getString("RestaurantName"));
        orderDetailDto.setCustomerEmail(rs.getString("CustomerEmail"));
        orderDetailDto.setFoodName(rs.getString("FoodName"));
        orderDetailDto.setPrice(rs.getDouble("Price"));
        orderDetailDto.setQuantity(rs.getInt("Quantity"));
        orderDetailDto.setCreatedDate(rs.getTimestamp("CreatedDate"));
        return orderDetailDto;
    }
}
