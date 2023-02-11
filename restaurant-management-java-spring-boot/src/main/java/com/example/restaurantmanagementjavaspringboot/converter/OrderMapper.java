package com.example.restaurantmanagementjavaspringboot.converter;

import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto entityToDto(Order order);

    Order dtoToEntity(OrderDto orderDto);
}
