package com.example.restaurantmanagementjavaspringboot.converter;

import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDto entitytoDto(Products products);

    Products dtoToEntity(ProductsDto productsDto);
}
