package com.example.foodservicev1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "orderfood")
@IdClass(OrderFoodPK.class)
public class OrderFood implements Serializable {
    @Id
    @Column(name = "orderid")
    private String orderId;
    @Id
    @Column(name = "foodid")
    private String foodId;
    @Column(name = "foodname")
    private String foodName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
}
