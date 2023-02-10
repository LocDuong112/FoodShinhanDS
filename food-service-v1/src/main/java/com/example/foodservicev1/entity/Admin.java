package com.example.foodservicev1.entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Admin {
    private String email;
    private String password;
    private String fullname;
    private String phone;
}
