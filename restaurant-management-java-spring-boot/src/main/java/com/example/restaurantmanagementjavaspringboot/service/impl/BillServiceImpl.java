package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.BillMapper;
import com.example.restaurantmanagementjavaspringboot.dto.BillDto;
import com.example.restaurantmanagementjavaspringboot.entity.Bill;
import com.example.restaurantmanagementjavaspringboot.repository.BillRepository;
import com.example.restaurantmanagementjavaspringboot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Resource
    private BillMapper billMapper;
    @Override
    public BillDto findBillOfOrder(long orderId){
        Bill billOfOrder = billRepository.findByOrderId(orderId);
        return billMapper.entityToDto(billOfOrder);
    }
    @Override
    public BillDto createBill(BillDto billDto){
        Bill bill = billMapper.dtoToEntity(billDto);
        bill = billRepository.save(bill);
        return billMapper.entityToDto(bill);
    }
}
