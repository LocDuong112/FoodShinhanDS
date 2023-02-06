package com.example.restaurantmanagementjavaspringboot.converter;


import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.mapstruct.factory.Mappers;

public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDto entitytoDto(Products account);

    Products dtoToEntity(ProductsDto accountDto);
}
