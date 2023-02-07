package com.example.restaurantmanagementjavaspringboot.controller;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("viewAccount")
    @ResponseBody
    public AccountListViewModel pageViewAllAccount(@RequestParam(value = "account_type", required = false , defaultValue = "0") int account_type,
                                                   @RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                                   final Model model) {
        AccountListViewModel viewModel = adminService.viewAllAccount(account_type, page_number);
//        model.addAttribute("account_info_list", data);

        return viewModel;
//        return "AdminViewAccount";
    }
}
