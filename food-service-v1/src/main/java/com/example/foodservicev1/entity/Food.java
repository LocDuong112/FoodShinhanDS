package com.example.foodservicev1.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Food {
    private String id;
    private String restaurantUsername;
    private String name;
    private double price;
    private String imageLink;
}