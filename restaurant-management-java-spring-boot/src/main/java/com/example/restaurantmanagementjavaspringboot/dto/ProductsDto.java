package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.ToString;

@ToString
public class ProductsDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
}
