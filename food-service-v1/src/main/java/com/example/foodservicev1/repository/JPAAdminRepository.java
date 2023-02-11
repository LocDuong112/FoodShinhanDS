package com.example.foodservicev1.repository;

import com.example.foodservicev1.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAAdminRepository extends JpaRepository<Admin, Long> {
    @Override
    List<Admin> findAll();
}
