package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;

public interface AccountService {

    AccountDto updateAccount(Long id, AccountDto accountDto);

    AccountDto signIn(String email, String password);

    AccountDto signUp(AccountDto accountDto);
}
