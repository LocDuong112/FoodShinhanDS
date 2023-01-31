package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = true)
    private Long id;
    private Long price;
    private String applyData;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id",insertable = false, updatable = false)
    private Account account;
    @OneToMany(mappedBy = "price")
    private Set<Products> products;

}
