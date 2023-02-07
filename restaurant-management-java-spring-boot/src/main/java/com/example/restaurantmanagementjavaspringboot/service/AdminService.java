package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;

public interface AdminService {

    AccountListViewModel viewAllAccount(int account_type, int page_number);

}
