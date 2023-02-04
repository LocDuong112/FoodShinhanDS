package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.AccountMapper;
import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.entity.Account;
import com.example.restaurantmanagementjavaspringboot.repository.AccountRepository;
import com.example.restaurantmanagementjavaspringboot.repository.RoleRepository;
import com.example.restaurantmanagementjavaspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        // 1. Check if id in database
        Optional<Account> account = accountRepository.findById(id);

        if (account.isEmpty()) {
            return null;
        }

        // 2. Update account
        Account updateAccount = accountMapper.INSTANCE.dtoToEntity(accountDto);

        updateAccount.setId(account.get().getId());
        updateAccount.setCarts(account.get().getCarts());
        updateAccount.setFeedBacks(account.get().getFeedBacks());
        updateAccount.setPrices(account.get().getPrices());
        updateAccount.setRole(roleRepository.findByRoleName(accountDto.getRoleName()));

        // 2.1. Keep old changes if new value is null
        if (updateAccount.getDob() == null && account.get().getDob() != null) {
            updateAccount.setDob(account.get().getDob());
        }
        if (updateAccount.getEmail() == null && account.get().getEmail() != null) {
            updateAccount.setEmail(account.get().getEmail());
        }
        if (updateAccount.getLoyaltyPoint() == null && account.get().getLoyaltyPoint() != null) {
            updateAccount.setLoyaltyPoint(account.get().getLoyaltyPoint());
        }
        if (updateAccount.getName() == null && account.get().getName() != null) {
            updateAccount.setName(account.get().getName());
        }
        if (updateAccount.getPassword() == null && account.get().getPassword() != null) {
            updateAccount.setPassword(account.get().getPassword());
        }
        if (updateAccount.getPhone() == null && account.get().getPhone() != null) {
            updateAccount.setPhone(account.get().getPhone());
        }

        // Return account
        AccountDto accountReturn = accountMapper.INSTANCE.entitytoDto(accountRepository.save(updateAccount));
        accountReturn.setRoleName(updateAccount.getRole().getRoleName());

        return accountReturn;
    }
}
