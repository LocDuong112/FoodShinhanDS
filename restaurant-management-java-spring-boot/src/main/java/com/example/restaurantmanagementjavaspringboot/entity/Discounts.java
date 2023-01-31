package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "discounts")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String note;
    private Time startDate;
    private Time endDate;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", insertable = false,updatable = false)
    private Products products;
}
