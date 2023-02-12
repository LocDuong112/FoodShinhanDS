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
@Table(name = "food")
public class Food {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "restaurantusername")
    private String restaurantUsername;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "imagelink")
    private String imageLink;
}