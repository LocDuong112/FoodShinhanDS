package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String description;
    private int quantity;
    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", insertable = false, updatable = false)
    private Categories categories;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id", insertable = false, updatable = false)
    private Price price;

    @OneToMany(mappedBy = "products")
    private Set<Discounts> discounts;

    @OneToMany(mappedBy = "products")
    private Set<FeedBack> feedBacks;

    @OneToMany(mappedBy = "products")
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "products")
    private Set<ProductCart> productCarts;



}
