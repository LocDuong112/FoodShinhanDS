package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    public List<ProductsDto> findProductsByNameByManager(String role, String name);
    public List<ProductsDto> findMostBuyProductsByCustomer(String role);
    public List<ProductsDto> findProductsByNameByCustomer(String role, String name);
}
