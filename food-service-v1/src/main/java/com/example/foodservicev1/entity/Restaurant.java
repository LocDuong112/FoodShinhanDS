package com.example.foodservicev1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @Column(name = "username", nullable = false)
    private String username;
    private String name;
    private String email;
    private String password;

    @Column(name = "image_link")
    private String imageLink;
    private String address;
}
