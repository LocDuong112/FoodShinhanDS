package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private String password;

    @Column(name = "loyalty_point")
    private Long loyaltyPoint;

    @Column(name = "is_validated")
    private boolean isValidated;

    @OneToMany(mappedBy = "account")
    private Set<Price> prices;

    @OneToMany(mappedBy = "account")
    private Set<Cart> carts;

    @OneToMany(mappedBy = "account")
    private Set<FeedBack> feedBacks;

    @OneToMany(mappedBy = "account")
    private Set<Order> orders;

    @OneToOne(mappedBy = "account")
    private Role role;


}
