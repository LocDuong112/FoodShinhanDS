package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
