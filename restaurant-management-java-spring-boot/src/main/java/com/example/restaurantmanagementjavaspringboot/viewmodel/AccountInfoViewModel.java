package com.example.restaurantmanagementjavaspringboot.viewmodel;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminEditAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountInfoViewModel {
    AdminEditAccountDto account;
    List<RoleDto> accountTypeList;
}
