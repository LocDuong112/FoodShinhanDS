package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateAccountDto {
    private Long id;
    private String name;
    private String password;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private Long loyaltyPoint;
    private boolean isValidated;
    private Long roleId;
}
