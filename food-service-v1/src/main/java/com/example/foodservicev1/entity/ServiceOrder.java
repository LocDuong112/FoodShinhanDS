package com.example.foodservicev1.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "service_order")
public class ServiceOrder {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "restaurant_username")
    private String restaurantUsername;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "created_date")
    private Timestamp createdDate;
}
