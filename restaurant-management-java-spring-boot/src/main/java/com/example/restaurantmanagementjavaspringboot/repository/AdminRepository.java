package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.convention.PageConvention;
import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<AdminViewAccountDto> getAccountByRole(int account_type, int pageNumber) {
        return jdbcTemplate
                .query("select id, name, phone, email, is_validated, is_deleted"
                                + " from account"
                                + " where account.role_id = " + account_type
                                + " offset (2*" + (pageNumber - 1) +") rows fetch next "+ PageConvention.objectPerPage +" rows only",
                        (rs, rowNum) ->
                                new AdminViewAccountDto(
                                        rs.getString("id"),
                                        rs.getString("name"),
                                        rs.getString("phone"),
                                        rs.getString("email"),
                                        rs.getBoolean("is_validated"),
                                        rs.getBoolean("is_deleted")
                                )
                );
    }

    public List<AdminViewAccountDto> getAllAccount(int pageNumber) {
        return jdbcTemplate
                .query("select id, name, phone, email, is_validated, is_deleted"
                                + " from account"
                                + " offset (2*" + (pageNumber - 1) +") rows fetch next "+ PageConvention.objectPerPage +" rows only",
                        (rs, rowNum) ->
                                new AdminViewAccountDto(
                                        rs.getString("id"),
                                        rs.getString("name"),
                                        rs.getString("phone"),
                                        rs.getString("email"),
                                        rs.getBoolean("is_validated"),
                                        rs.getBoolean("is_deleted")
                                )
                );
    }

    public List<RoleDto> getAllRole() {
        return jdbcTemplate
                .query("select * from role",
                        (rs, rowNum) ->
                                new RoleDto(
                                        rs.getLong("id"),
                                        rs.getString("role_name")
                                )
                );
    }

    public Integer getTotalPageAccountByRole(int account_type) {
            return jdbcTemplate
                    .queryForObject("select ceil(count(*)/ "+ PageConvention.objectPerPage +")"
                                    + " from account"
                                    + " where account.role_id = " + account_type,
                            Integer.class
                    );
    }

    public Integer getTotalPageAllAccount() {
        return jdbcTemplate
                .queryForObject("select ceil(count(*)/ "+ PageConvention.objectPerPage +")"
                                + " from account",
                        Integer.class
                );
    }
}
