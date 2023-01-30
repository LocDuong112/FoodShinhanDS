package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;
    private String name;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private String password;
    private Long loyaltyPoint;

    private boolean isValidated;
    @OneToMany(mappedBy = "account")
    private Set<Price> prices;

    @OneToMany(mappedBy = "account")
    private Set<Cart> carts;

    @OneToMany(mappedBy = "account")
    private Set<FeedBack> feedBacks;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;



}
