package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.AccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.StaffAccountDto;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("viewAllStaffAccount")
    @ResponseBody
    public List<StaffAccountDto> viewAllStaffAccount(@RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                      final Model model) {
        List<StaffAccountDto> data = adminService.viewAllStaffAccount(page_number);
        model.addAttribute("account_list", data);
        model.addAttribute("current_account_view", "staff");
        model.addAttribute("current_page", page_number);

        return data;
//        return "AdminViewAccount";
    }
}
