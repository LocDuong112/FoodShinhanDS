package com.example.restaurantmanagementjavaspringboot.viewmodel;

import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountListViewModel {
    int totalPage;
    int currentPage;
    List<RoleDto> accountTypeList;
    List<AdminViewAccountDto> accountList;

}
