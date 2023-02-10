package com.example.foodservicev1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Restaurant {
    private String username;
    private String name;
    private String email;
    private String password;
    private String imageLink;
    private String address;
}
