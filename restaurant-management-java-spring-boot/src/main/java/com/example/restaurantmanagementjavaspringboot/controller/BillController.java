package com.example.restaurantmanagementjavaspringboot.controller;

import com.example.restaurantmanagementjavaspringboot.dto.BillDto;
import com.example.restaurantmanagementjavaspringboot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping("/order/{orderId}")
    public ResponseEntity<BillDto> getBillOfOrder(@PathVariable("orderId") long orderId) {
        BillDto billDto = billService.findBillOfOrder(orderId);
        if (billDto!=null) {
            BillDto BillDto;
            return new ResponseEntity<>(billDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addBill")
    public BillDto createBill(@RequestBody BillDto billDto){
        return billService.createBill(billDto);
    }
}
