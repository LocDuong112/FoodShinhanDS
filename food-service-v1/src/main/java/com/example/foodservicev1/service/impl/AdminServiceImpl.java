package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.Admin;
import com.example.foodservicev1.repository.AdminRepository;
import com.example.foodservicev1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findByEmail(String email) { return adminRepository.findByEmail(email); }

    @Override
    public int save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public int update(Admin admin) {
        return adminRepository.update(admin);
    }

    @Override
    public int delete(String email) {
        return adminRepository.delete(email);
    }

    @Override
    public int login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null) {
            return -1;
        } else if (admin.getPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
}
