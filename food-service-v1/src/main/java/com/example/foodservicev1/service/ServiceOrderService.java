package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.ServiceOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceOrderService {
    public List<ServiceOrder> find();
    public List<ServiceOrder> findByRestaurantUsername(String restaurantUsername);
    public List<ServiceOrder> findByCustomerEmail(String customerEmail);
    public ServiceOrder findById(String id);
    public int save(ServiceOrder serviceOrder);
    public int delete(String id);
}
