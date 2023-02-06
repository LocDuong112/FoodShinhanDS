package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;

import java.util.List;

public interface ProductsService {

    List<ProductsDto> loadProductsCustomer(String role, Long id, Long fetchNum);
}
