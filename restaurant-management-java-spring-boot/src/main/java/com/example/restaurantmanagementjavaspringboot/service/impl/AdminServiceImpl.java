package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.repository.AdminRepository;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public AccountListViewModel viewAllAccount(int account_type, int page_number) {

        if (account_type == 0)
            return new AccountListViewModel(
                    adminRepository.getTotalPageAllAccount(),
                    page_number,
                    adminRepository.getAllRole(),
                    adminRepository.getAllAccount(page_number)
            );

        return new AccountListViewModel(
                adminRepository.getTotalPageAccountByRole(account_type),
                page_number,
                adminRepository.getAllRole(),
                adminRepository.getAccountByRole(account_type, page_number)
        );
    }

}
