package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("updateAccount/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") Long id, @RequestBody AccountDto accountDto) {
        try {
            AccountDto accountResult = accountService.updateAccount(id, accountDto);

            if (accountResult == null ) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(accountResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("signIn")
    public ResponseEntity<AccountDto> signIn(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        try {
            AccountDto signInAccount = accountService.signIn(email, password);
            if (signInAccount == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(signInAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("signUp/{role}")
    public ResponseEntity<AccountDto> signUp(@PathVariable("role") String role, @RequestBody AccountDto accountDto) {
        accountDto.setRoleName(role);

        try {
            AccountDto signUpAccount = accountService.signUp(accountDto);
            if (signUpAccount == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(signUpAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
