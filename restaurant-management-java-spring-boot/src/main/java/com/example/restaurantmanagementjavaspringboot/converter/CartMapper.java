package com.example.restaurantmanagementjavaspringboot.converter;

import com.example.restaurantmanagementjavaspringboot.dto.CartDto;
import com.example.restaurantmanagementjavaspringboot.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    CartDto entityToDto(Cart cart);
    Cart dtoToEntity(CartDto cartDto);
}
