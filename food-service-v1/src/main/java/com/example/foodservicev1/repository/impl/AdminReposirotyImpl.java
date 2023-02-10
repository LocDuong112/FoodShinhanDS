package com.example.foodservicev1.repository.impl;

import com.example.foodservicev1.entity.Admin;
import com.example.foodservicev1.mapper.AdminRowMapper;
import com.example.foodservicev1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminReposirotyImpl implements AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Admin> findAll() {
        return jdbcTemplate.query("SELECT * FROM ADMIN", new AdminRowMapper());
    }

    @Override
    public Admin findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ADMIN WHERE Email = ?", new AdminRowMapper(), email);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int save(Admin admin) {
        try {
            return jdbcTemplate.update("INSERT INTO ADMIN ( Email, Password, Fullname, Phone )" +
                            "VALUES ( ?, ?, ?, ? )",
                    new Object[]{admin.getEmail(), admin.getPassword(), admin.getFullname(), admin.getPhone()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(Admin admin) {
        try {
            return jdbcTemplate.update("UPDATE ADMIN SET " +
                        "Password = ?, Fullname = ?, Phone = ? WHERE Email = ?",
                new Object[]{admin.getPassword(), admin.getFullname(), admin.getPhone(), admin.getEmail()});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(String email) {
        try {
            return jdbcTemplate.update("DELETE FROM ADMIN WHERE Email = ?", email);
        } catch (Exception e) {
            return 0;
        }
    }
}
