package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.AccountMapper;
import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.entity.Account;
import com.example.restaurantmanagementjavaspringboot.repository.AccountRepository;
import com.example.restaurantmanagementjavaspringboot.repository.RoleRepository;
import com.example.restaurantmanagementjavaspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
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

    @Override
    public AccountDto signIn(String email, String password) {
        // Hash password
        password = hashPassword(password);

        // Check if account is in db
        Optional<Account> account = accountRepository.findByEmailAndPasswordAndIsDeleted(email, password, false);
        if (account.isEmpty()) {
            return null;
        }

        // Return account
        AccountDto accountReturn = accountMapper.INSTANCE.entitytoDto(account.get());
        accountReturn.setRoleName(account.get().getRole().getRoleName());

        return accountReturn;
    }

    @Override
    public AccountDto signUp(AccountDto accountDto) {
        // check for email
        Optional<Account> account = accountRepository.findByEmail(accountDto.getEmail());

        if (account.isPresent()) {
            return null;
        }

        // Create new account
        Account newAccount = accountMapper.INSTANCE.dtoToEntity(accountDto);
        newAccount.setPassword(hashPassword(accountDto.getPassword()));
        newAccount.setRole(roleRepository.findByRoleName(accountDto.getRoleName()));

        // Return account
        AccountDto accountReturn = accountMapper.INSTANCE.entitytoDto(accountRepository.save(newAccount));
        accountReturn.setRoleName(newAccount.getRole().getRoleName());

        return accountReturn;
    }

    //    https://www.geeksforgeeks.org/md5-hash-in-java/
//    Check this ref for further on hashing password
    private String hashPassword(String input) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
