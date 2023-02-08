package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.converter.ProductsMapper;
import com.example.restaurantmanagementjavaspringboot.dto.ProductsDto;
import com.example.restaurantmanagementjavaspringboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/")
@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;


    @GetMapping(value = {"product/manager/{name}", "product/manager/", "product/manager"})
    public ResponseEntity<List<ProductsDto>> findProductsByNameByManager(
            @PathVariable(required = false) String name) {
        try {
            Optional<String> optional = Optional.ofNullable(name);
            List<ProductsDto> productsListResult
                    = productsService.findProductsByNameByManager("MANAGER", optional.orElse(""));

            if (productsListResult == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productsListResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = {"product/customer/{name}", "product/customer/", "product/customer"})
    public ResponseEntity<List<ProductsDto>> findProductsByNameByCustomer(
            @PathVariable(required = false) String name) {
        try {
            Optional<String> optional = Optional.ofNullable(name);
            List<ProductsDto> productsListResult
                    = productsService.findProductsByNameByCustomer("CUSTOMER", optional.orElse(""));

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
                    = productsService.findMostBuyProductsByCustomer("CUSTOMER");

            if (productsListResult == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productsListResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
