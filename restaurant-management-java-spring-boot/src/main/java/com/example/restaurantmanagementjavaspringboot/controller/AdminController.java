package com.example.restaurantmanagementjavaspringboot.controller;
import com.example.restaurantmanagementjavaspringboot.dto.AdminCreateAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminEditAccountDto;
import com.example.restaurantmanagementjavaspringboot.dto.AdminViewAccountDto;
import com.example.restaurantmanagementjavaspringboot.service.AdminService;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountInfoViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountListViewModel;
import com.example.restaurantmanagementjavaspringboot.viewmodel.AccountTemplateViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("viewAllAccount")
    @ResponseBody
    public AccountListViewModel viewAllAccountPage(@RequestParam(value = "account_type", required = false , defaultValue = "0") int account_type,
                                                   @RequestParam(value = "page", required = false , defaultValue = "1") int page_number,
                                                   final Model model) {
        AccountListViewModel viewModel = adminService.viewAllAccount(account_type, page_number);
        model.addAttribute("Model", viewModel);

        return viewModel;
//        return "AdminViewAccount";
    }

    @GetMapping("takeAllAccount")
    @ResponseBody
    public Map<String, List<AdminViewAccountDto>> viewAllAccountComponent(@RequestParam(value = "account_type", required = false , defaultValue = "0") int account_type,
                                                                          @RequestParam(value = "page", required = false , defaultValue = "1") int page_number) {

        Map<String, List<AdminViewAccountDto>> map = new HashMap<>();
        map.put("account_list", adminService.takeAllAccount(account_type, page_number));

        return map;
    }

    @GetMapping("IndividualAccount")
    @ResponseBody
    public AccountInfoViewModel viewIndividualAccountPage(@RequestParam(value = "account_id") long id,
                                                          final Model model) {
        AccountInfoViewModel viewModel = adminService.viewIndividualAccount(id);
        model.addAttribute("Model", viewModel);

        return viewModel;
//        return "AdminViewAccount";
    }

    @PutMapping("IndividualAccount")
    public String editIndividualAccount(@RequestBody @Valid AdminEditAccountDto accountDto,
                                        HttpServletRequest request) {
        adminService.editIndividualAccount(accountDto);

        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
//        return "AdminViewAccount";
    }

    @DeleteMapping("IndividualAccount")
    public String deleteIndividualAccount(@RequestParam(value = "account_id") long id,
                                          HttpServletRequest request) {
        adminService.deleteIndividualAccount(id);

        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
//        return "AdminViewAccount";
    }

    @GetMapping("templateIndividualAccount")
    @ResponseBody
    public AccountTemplateViewModel templateIndividualAccountPage(final Model model) {
        AccountTemplateViewModel viewModel = adminService.templateIndividualAccount();
        model.addAttribute("Model", viewModel);

        return viewModel;
//        return "AdminViewAccount";
    }

    @PostMapping("IndividualAccount")
    public String createIndividualAccount(@RequestBody @Valid AdminCreateAccountDto accountDto,
                                        HttpServletRequest request) {
        adminService.createIndividualAccount(accountDto);

        String referer = request.getHeader("Referer");
        return "redirect:"+referer;
//        return "AdminViewAccount";
    }
}
