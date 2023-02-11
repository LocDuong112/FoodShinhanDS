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
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "restaurant_username")
    private String restaurantUsername;
    private String name;
    private double price;

    @Column(name = "image_link")
    private String imageLink;
}