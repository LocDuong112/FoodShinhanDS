package com.example.restaurantmanagementjavaspringboot.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEditAccountDto {
    @NotNull
    private Long id;
    @NotBlank(message = "Name can not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long")
    private String name;
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
    private boolean isValidated;
    @NotNull
    private Long roleId;
}
