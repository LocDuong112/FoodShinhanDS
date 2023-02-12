package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;
import com.example.restaurantmanagementjavaspringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("status/{id}")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable("id") long id, @RequestBody OrderDto orderDto) {
        OrderDto _orderDto = (OrderDto) orderService.findById(id);
        if (_orderDto!=null){
            _orderDto.setStatus(orderDto.getStatus());
            return new ResponseEntity<>(orderService.createOrder(_orderDto), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
