package com.example.foodservicev1.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderFood {
    private String orderId;
    private String foodId;
    private String foodName;
    private int quantity;
    private double price;
}
