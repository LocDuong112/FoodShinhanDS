package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminCreateAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminEditAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountInfoViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountTemplateViewModel;

import java.util.List;

public interface AdminService {

    AccountListViewModel viewAllAccount(int account_type, int page_number);

    List<AdminViewAccountDto> takeAllAccount(int account_type, int page_number);

    AccountInfoViewModel viewIndividualAccount(long id);


    int editIndividualAccount(AdminEditAccountDto accountDto);

    int deleteIndividualAccount(long id);

    AccountTemplateViewModel templateIndividualAccount();

    int createIndividualAccount(AdminCreateAccountDto accountDto);
}
