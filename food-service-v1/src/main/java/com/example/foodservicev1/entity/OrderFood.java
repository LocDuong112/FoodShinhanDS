package com.example.foodservicev1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "order_food")
public class OrderFood {
    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "food_id")
    private String foodId;

    @Column(name = "food_name")
    private String foodName;
    private int quantity;
    private double price;
}
