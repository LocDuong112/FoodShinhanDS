package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.ProductsMapper;
import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import com.example.restaurantmanagementjavaspringboot.repository.ProductsRepository;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public List<ProductsDto> findProductsByNameByManager(String role, String name) {
        if (role.equals("MANAGER")) {
            return productsMapper.INSTANCE.entityListtoDtoList(productsRepository.findProductsByName(name));
        }
        return null;
    }

    @Override
    public List<ProductsDto> findProductsByNameByCustomer(String role, String name) {
        if (role.equals("CUSTOMER")) {
            return productsMapper.INSTANCE.entityListtoDtoList(productsRepository.findProductsByName(name));
        }
        return null;
    }

    @Override
    public List<ProductsDto> findMostBuyProductsByCustomer(String role) {
        if (role.equals("CUSTOMER")) {
            return productsMapper.INSTANCE.entityListtoDtoList(productsRepository.findMostBuyProducts());
        }
        return null;
    }


}
