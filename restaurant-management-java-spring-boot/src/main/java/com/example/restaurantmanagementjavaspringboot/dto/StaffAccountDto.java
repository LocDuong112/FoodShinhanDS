package com.example.restaurantmanagementjavaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.MapKeyColumn;
import java.beans.BeanProperty;

@Data
@Setter
@Getter
@AllArgsConstructor
public class StaffAccountDto {
    private String name;
    private String phone;
    private String email;
    private boolean isValidated;
    private boolean isDeleted;
}
