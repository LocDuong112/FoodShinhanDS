package com.example.restaurantmanagementjavaspringboot.repository;

import com.example.restaurantmanagementjavaspringboot.convention.PageConvention;
import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminEditAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
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
                                + " where is_deleted = 0 and account.role_id = " + account_type
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
                                + " where is_deleted = 0"
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

    public int getTotalPageAccountByRole(int account_type) {
            Integer result = jdbcTemplate
                    .queryForObject("select ceil(count(*)/ "+ PageConvention.objectPerPage +")"
                                    + " from account"
                                    + " where account.role_id = " + account_type,
                            Integer.class
                    );

            return result == null ? 0 : result;
    }

    public int getTotalPageAllAccount() {
        Integer result = jdbcTemplate
                .queryForObject("select ceil(count(*)/ "+ PageConvention.objectPerPage +")"
                                + " from account",
                        Integer.class
                );
        return result == null ? 0 : result;
    }

    public AdminEditAccountDto getAccountInfoById(long id) {
        return jdbcTemplate
                .queryForObject("select account.id, name, dob, gender, phone, email, password, loyalty_point, is_validated, account.role_id, is_deleted"
                                + " from account, role"
                                + " where account.id = " + String.valueOf(id) + " and account.role_id = role.id",
                        (rs, rowNum) ->
                                new AdminEditAccountDto(
                                        rs.getLong("id"),
                                        rs.getString("name"),
                                        rs.getString("dob"),
                                        rs.getBoolean("gender"),
                                        rs.getString("phone"),
                                        rs.getString("email"),
                                        rs.getLong("loyalty_point"),
                                        rs.getBoolean("is_validated"),
                                        rs.getLong("role_id")
                                )
                );
    }

    public int editAccount(AdminEditAccountDto accountDto) {
//        return jdbcTemplate.update("UPDATE ACCOUNT"
//                +" SET DOB = "+ accountDto.getDob()
//                +", EMAIL = "+ accountDto.getEmail()
//                +", GENDER = "+ accountDto.isGender()
//                +", IS_VALIDATED = "+ accountDto.isValidated()
//                +", LOYALTY_POINT = "+ accountDto.getLoyaltyPoint()
//                +", NAME = "+ accountDto.getName()
//                +", PHONE = "+ accountDto.getPhone()
//                +", ROLE_ID = "+ accountDto.getRoleId()
//                +" WHERE ID = "+ accountDto.getId()
//                +" and IS_DELETED = 0"
//                +" and not exists (select id from account where "
//                        +" ID = "+ accountDto.getId()
//                        +" and DOB = "+ accountDto.getDob()
//                        +" and EMAIL = "+ accountDto.getEmail()
//                        +" and GENDER = "+ accountDto.isGender()
//                        +" and IS_VALIDATED = "+ accountDto.isValidated()
//                        +" and LOYALTY_POINT = "+ accountDto.getLoyaltyPoint()
//                        +" and NAME = "+ accountDto.getName()
//                        +" and PHONE = "+ accountDto.getPhone()
//                        +" and ROLE_ID = "+ accountDto.getRoleId()
//                +")");
        return jdbcTemplate.update("UPDATE ACCOUNT"
                +" SET DOB = "+ (accountDto.getDob() == null ? null : "'" + accountDto.getDob() + "'")
                +", EMAIL = '"+ accountDto.getEmail() + "'"
                +", GENDER = "+ (accountDto.isGender() ? 1 : 0)
                +", IS_VALIDATED = "+ (accountDto.isValidated() ? 1 : 0)
                +", LOYALTY_POINT = "+ accountDto.getLoyaltyPoint()
                +", NAME = '"+ accountDto.getName() + "'"
                +", PHONE = '"+ accountDto.getPhone() + "'"
                +", ROLE_ID = "+ accountDto.getRoleId()
                +" WHERE ID = "+ accountDto.getId()
                +" and IS_DELETED = 0"
                +" and not exists (select id from account where "
                                +" ID = "+ accountDto.getId()
                                +" and DOB "+ (accountDto.getDob() == null ? "is null" : "= '" + accountDto.getDob() + "'")
                                +" and EMAIL = '"+ accountDto.getEmail() + "'"
                                +" and GENDER = "+ (accountDto.isGender() ? 1 : 0)
                                +" and IS_VALIDATED = "+ (accountDto.isValidated() ? 1 : 0)
                                +" and LOYALTY_POINT = "+ accountDto.getLoyaltyPoint()
                                +" and NAME = '"+ accountDto.getName() + "'"
                                +" and PHONE = '"+ accountDto.getPhone() + "'"
                                +" and ROLE_ID = "+ accountDto.getRoleId()
                                +")"
        );

//        return jdbcTemplate.update("UPDATE ACCOUNT"
//                +" SET DOB = ?"
//                +", EMAIL = ?"
//                +", GENDER = ?"
//                +", IS_VALIDATED = ?"
//                +", LOYALTY_POINT = ?"
//                +", NAME = ?"
//                +", PHONE = ?"
//                +", ROLE_ID = ?"
//                +" WHERE ID = ?"
//                +" and IS_DELETED = 0",
//                accountDto.getDob(),
//                accountDto.getEmail(),
//                accountDto.isGender(),
//                accountDto.isValidated(),
//                accountDto.getLoyaltyPoint(),
//                accountDto.getName(),
//                accountDto.getPhone(),
//                accountDto.getRoleId(),
//                accountDto.getId());

//        return jdbcTemplate.update("update account set name = 'Jones' where id = 2");
    }
}
