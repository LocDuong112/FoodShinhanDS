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
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    private String password;
    private String fullname;
    private String phone;
}
