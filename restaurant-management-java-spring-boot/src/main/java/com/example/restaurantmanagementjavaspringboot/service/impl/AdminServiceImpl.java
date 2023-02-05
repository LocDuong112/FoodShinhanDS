package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.dto.StaffAccountDto;
import com.example.restaurantmanagementjavaspringboot.repository.AdminRepository;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<StaffAccountDto> viewAllStaffAccount(int page_number) {

        return adminRepository.getAllStaffAccount(page_number);
    }
}
