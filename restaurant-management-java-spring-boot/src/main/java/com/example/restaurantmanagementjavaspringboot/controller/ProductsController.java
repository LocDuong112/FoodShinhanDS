package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.converter.ProductsMapper;
import com.example.restaurantmanagementjavaspringboot.entity.Products;
import com.example.restaurantmanagementjavaspringboot.repository.ProductsRepository;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // Nó còn lỗi, khoan merge!!!
    /*@GetMapping("/api/product/manager/{name}")
    public List<Products> findProductsByNameByManager(@PathVariable String name){
        return productsService.findProductsByNameByManager(name);
    }

    @GetMapping("/api/product/manager/{name}")
    public List<Products> findProductsByNameByCustomer(@PathVariable String name){
        return productsService.findProductsByNameByCustomer(name);
    }

    @GetMapping("/api/product/customer/most-buy-product")
    public List<Products> findMostBuyProductsByCustomer(){
        return productsService.findMostBuyProductsByCustomer();
    }*/

    /*@Autowired
    private ProductsMapper productsMapper;

    @GetMapping("/api/product/manager/{name}")
    public String findProductsByNameByManager(@PathVariable String name){
        System.out.println(productsMapper.INSTANCE.entitytoDto(productsService.findProductsByNameByManager(name).get(0)));
        System.out.println(productsService.findProductsByNameByManager(name).get(0));
        return "Hi";
    }*/
}