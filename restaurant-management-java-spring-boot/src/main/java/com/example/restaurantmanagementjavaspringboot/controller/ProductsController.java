package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.converter.ProductsMapper;
import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsMapper productsMapper;

    @GetMapping("product/manager/{name}")
    public ResponseEntity<List<ProductsDto>> findProductsByNameByManager(@PathVariable String name) {
        try {
            List<ProductsDto> productsListResult
                    = productsMapper.INSTANCE.entityListtoDtoList(productsService.findProductsByNameByManager("MANAGER", name));

            if (productsListResult == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productsListResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/customer/{name}")
    public ResponseEntity<List<ProductsDto>> findProductsByNameByCustomer(@PathVariable String name) {
        try {
            List<ProductsDto> productsListResult
                    = productsMapper.INSTANCE.entityListtoDtoList(productsService.findProductsByNameByCustomer("CUSTOMER", name));

            if (productsListResult == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productsListResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/customer/most-buy-product")
    public ResponseEntity<List<ProductsDto>> findMostBuyProductsByCustomer() {
        try {
            List<ProductsDto> productsListResult
                    = productsMapper.INSTANCE.entityListtoDtoList(productsService.findMostBuyProductsByCustomer("CUSTOMER"));

            if (productsListResult == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productsListResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
