package com.example.restaurantmanagementjavaspringboot.dto;

import com.example.restaurantmanagementjavaspringboot.convention.RoleConvention;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Setter
@Getter
public class AdminCreateAccountDto {
    @NotBlank(message = "Name can not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long")
    private String name;
    @NotBlank(message = "Password can not be empty")
    @Size(min = 6, max = 50, message = "password must be between 6 and 50 characters long")
    private String password;
    @NotNull(message="Date of birth is a required field")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}", message="Invalid status date")
    private String dob;
    private boolean gender;
    @NotBlank(message = "Phone number can not be empty")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters long")
    private String phone;
    @Email
    private String email;
    @NotNull
    private Long loyaltyPoint;
    @NotNull
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
