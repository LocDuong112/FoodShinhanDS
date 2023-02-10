package com.example.restaurantmanagementjavaspringboot.dto;

import com.example.restaurantmanagementjavaspringboot.entity.Account;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String createdDate;
    private Long accountId;

}
