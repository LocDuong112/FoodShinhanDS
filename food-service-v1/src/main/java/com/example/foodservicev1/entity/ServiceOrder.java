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
@Table(name="serviceorder")
public class ServiceOrder {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "restaurantusername")
    private String restaurantUsername;
    @Column(name = "restaurantname")
    private String restaurantName;
    @Column(name = "customeremmail")
    private String customerEmail;
    @Column(name = "createddate")
    private Timestamp createdDate;
}
