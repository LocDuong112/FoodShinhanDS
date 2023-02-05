package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.StaffAccountDto;

import java.util.List;

public interface AdminService {

    List<StaffAccountDto> viewAllStaffAccount(int page_number);
}
