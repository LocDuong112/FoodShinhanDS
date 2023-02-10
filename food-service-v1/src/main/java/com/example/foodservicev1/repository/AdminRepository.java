package com.example.foodservicev1.repository;

import com.example.foodservicev1.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository {
    public List<Admin> findAll();
    public Admin findByEmail(String email);
    public int save(Admin admin);
    public int update(Admin admin);
    public int delete(String email);
}
