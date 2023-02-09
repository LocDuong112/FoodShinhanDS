package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
public class AdminViewAccountDto {
    private String id;
    private String name;
    private String phone;
    private String email;
    private boolean isValidated;
    private boolean isDeleted;
}
