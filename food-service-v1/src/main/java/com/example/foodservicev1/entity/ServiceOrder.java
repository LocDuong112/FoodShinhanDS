package com.example.foodservicev1.entity;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ServiceOrder {
    private String id;
    private String restaurantUsername;
    private String restaurantName;
    private String customerEmail;
    private Timestamp createdDate;
}
