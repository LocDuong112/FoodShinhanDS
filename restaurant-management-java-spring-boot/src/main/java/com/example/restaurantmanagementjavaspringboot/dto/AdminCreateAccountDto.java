package com.example.restaurantmanagementjavaspringboot.dto;

import com.example.restaurantmanagementjavaspringboot.convention.RoleConvention;
import lombok.*;

@Data
@Setter
@Getter
public class AdminCreateAccountDto {
    private String name;
    private String password;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private Long loyaltyPoint;
    private Long roleId;

    public AdminCreateAccountDto() {
        name = "Anakin Skywalker";
        password = "*******";
        dob = "DD/MM/YYYY";
        gender = true;
        phone = "0123456789";
        email = "anakin@gmail.com";
        loyaltyPoint = 0L;
        roleId = RoleConvention.STAFF;
    }
}
