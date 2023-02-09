package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class AdminEditAccountDto {
    private Long id;
    private String name;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private Long loyaltyPoint;
    private boolean isValidated;
    private Long roleId;
}
