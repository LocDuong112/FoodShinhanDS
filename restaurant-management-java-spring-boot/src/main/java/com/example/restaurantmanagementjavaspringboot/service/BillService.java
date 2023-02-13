package com.example.restaurantmanagementjavaspringboot.service;

import com.example.restaurantmanagementjavaspringboot.dto.BillDto;

import java.util.List;

public interface BillService {
    public BillDto findBillOfOrder(long orderId);
    public BillDto createBill(BillDto billDto);
}
