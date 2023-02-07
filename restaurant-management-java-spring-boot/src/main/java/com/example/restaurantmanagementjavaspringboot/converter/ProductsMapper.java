package com.example.restaurantmanagementjavaspringboot.converter;


import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDto entitytoDto(Products products);

    List<ProductsDto> entityListtoDtoList(List<Products> productsList);

    Products dtoToEntity(ProductsDto productsDto);
}
