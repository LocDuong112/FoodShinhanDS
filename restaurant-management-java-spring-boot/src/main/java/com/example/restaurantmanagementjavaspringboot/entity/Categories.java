package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "categories")
    private Set<Products> products;
}
