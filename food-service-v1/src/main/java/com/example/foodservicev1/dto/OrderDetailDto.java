package com.example.foodservicev1.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetailDto {
    private String id;
    private String restaurantName;
    private String customerEmail;
    private String foodName;
    private double price;
    private int quantity;
    private Timestamp createdDate;
}
