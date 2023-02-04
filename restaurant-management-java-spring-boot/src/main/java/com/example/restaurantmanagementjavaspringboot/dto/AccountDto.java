package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private String password;
    private Long loyaltyPoint;
    private boolean isValidated;
    private String roleName;
    private boolean isDeleted;
}
