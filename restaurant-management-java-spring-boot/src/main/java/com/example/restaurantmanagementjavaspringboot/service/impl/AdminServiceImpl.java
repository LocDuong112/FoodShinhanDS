package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminCreateAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminEditAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.repository.AdminRepository;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountInfoViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountTemplateViewModel;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<AdminViewAccountDto> takeAllAccount(int account_type, int page_number) {
        if (account_type == 0) return adminRepository.getAllAccount(page_number);

        return adminRepository.getAccountByRole(account_type, page_number);
    }

    @Override
    public AccountInfoViewModel viewIndividualAccount(long id) {
        return new AccountInfoViewModel(
                adminRepository.getAccountInfoById(id),
                adminRepository.getAllRole()
        );
    }

    @Override
    public int editIndividualAccount(AdminEditAccountDto accountDto) {
        return adminRepository.editAccount(accountDto);
    }

    @Override
    public int deleteIndividualAccount(long id) {
        return adminRepository.deleteAccount(id);
    }

    @Override
    public AccountTemplateViewModel templateIndividualAccount() {
        return new AccountTemplateViewModel(new AdminCreateAccountDto(), adminRepository.getAllRole());
    }

    @Override
    public int createIndividualAccount(AdminCreateAccountDto accountDto) {
        accountDto.setPassword(BCrypt.hashpw(accountDto.getPassword(), BCrypt.gensalt(7)));
        return adminRepository.createAccount(accountDto);
    }

}
