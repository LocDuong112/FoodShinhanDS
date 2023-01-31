package com.example.restaurantmanagementjavaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false)
    private Long id;
    private String customerNote;
    private float totalPrice;
    private String status;
    private String paymentStatus;
    private String paymentDate;
    private String paymentMethod;
    private String note;
    private String shipAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_order_id", updatable = false,nullable = false)
    private AccountOrder accountOrder;

    @OneToMany(mappedBy = "order")
    private Set<Bill> billSet;

}
