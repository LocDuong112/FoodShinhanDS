package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;
import com.example.restaurantmanagementjavaspringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


   // test controller findAll Order
    @GetMapping("/orders")
    public List<OrderDto> findAllOrder(){
        return orderService.findAll();
    }

//    @GetMapping("/orders")
//    public String findAllOrder(Model model){
//        List<OrderDto> orderDtos =orderService.findAll();
//        model.addAttribute("orders", orderDtos);
//        return "page-maneger-order";
//    }

    @PostMapping("/addOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}
