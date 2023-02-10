package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String customerNote;
    private float totalPrice;
    private String paymentStatus;
    private String paymentDate;
    private String paymentMethod;
    private String shipAddress;
    private String status;
    private String note;
    private Long accountId;


}
