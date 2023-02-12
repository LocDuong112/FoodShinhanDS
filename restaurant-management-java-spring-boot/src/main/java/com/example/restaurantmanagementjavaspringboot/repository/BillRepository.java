package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByOrderId(long orderId);
}