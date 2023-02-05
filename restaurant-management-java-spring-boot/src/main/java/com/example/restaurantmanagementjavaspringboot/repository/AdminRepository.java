package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.dto.StaffAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<StaffAccountDto> getAllStaffAccount(int pageNumber) {
        return jdbcTemplate
                .query("select name, phone, email, is_validated, is_deleted"
                                + " from account, role"
                                + " where account.role_id = role.id and role.role_name = 'staff'"
                                + " offset (2*" + (pageNumber - 1) +") rows fetch next 2 rows only",
                        (rs, rowNum) ->
                                new StaffAccountDto(rs.getString("name"),
                                        rs.getString("phone"),
                                        rs.getString("email"),
                                        rs.getBoolean("is_validated"),
                                        rs.getBoolean("is_deleted")
                                )
                );
    }
}
