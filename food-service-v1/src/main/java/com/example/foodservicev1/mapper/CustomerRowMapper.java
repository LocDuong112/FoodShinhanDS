package com.example.foodservicev1.mapper;


import com.example.foodservicev1.entity.Admin;
import com.example.foodservicev1.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setEmail(rs.getString("Email"));
        customer.setPassword(rs.getString("Password"));
        customer.setFullname(rs.getString("Fullname"));
        customer.setPhone(rs.getString("Phone"));
        return customer;
    }
}
