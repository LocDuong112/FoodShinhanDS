package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    public List<Admin> findAll();
    public Admin findByEmail(String email);
    public int save(Admin admin);
    public int update(Admin admin);
    public int delete(String email);
    public int login(String email, String password);
}
