package com.example.foodservicev1.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    private String password;
    private String fullname;
    private String phone;
}
