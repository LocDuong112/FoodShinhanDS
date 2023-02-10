package com.example.foodservicev1.mapper;

import com.example.foodservicev1.entity.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setEmail(rs.getString("Email"));
        admin.setPassword(rs.getString("Password"));
        admin.setFullname(rs.getString("Fullname"));
        admin.setPhone(rs.getString("Phone"));
        return admin;
    }
}
