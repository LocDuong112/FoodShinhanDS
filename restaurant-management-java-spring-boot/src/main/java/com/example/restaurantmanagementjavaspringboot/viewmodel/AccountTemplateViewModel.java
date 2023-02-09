package com.example.restaurantmanagementjavaspringboot.viewmodel;

import com.example.restaurantmanagementjavaspringboot.dto.AdminCreateAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountTemplateViewModel {
    AdminCreateAccountDto account;
    List<RoleDto> accountTypeList;
}
