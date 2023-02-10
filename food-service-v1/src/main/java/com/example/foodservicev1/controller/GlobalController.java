package com.example.foodservicev1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class GlobalController {
    public String index() {
        return "index";
    }
}
