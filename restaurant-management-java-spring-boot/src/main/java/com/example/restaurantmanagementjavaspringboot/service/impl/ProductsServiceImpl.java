package com.example.restaurantmanagementjavaspringboot.service.impl;

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

    @Override
    public List<Products> findProductsByNameByManager(String name) {
        if (true /*product role, not have function yet*/) {
            return productsRepository.findProductsByName(name);
        }
        return null;
    }

    @Override
    public List<Products> findProductsByNameByCustomer(String name) {
        if (true /*customer role, not have function yet*/) {
            return productsRepository.findProductsByName(name);
        }
        return null;
    }

    @Override
    public List<Products> findMostBuyProducts() {
        return productsRepository.findMostBuyProducts();
    }


}
