package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.ServiceOrder;
import com.example.foodservicev1.repository.ServiceOrderRepository;
import com.example.foodservicev1.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderSericeImpl implements ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Override
    public List<ServiceOrder> find() {
        return serviceOrderRepository.find();
    }

    @Override
    public List<ServiceOrder> findByRestaurantUsername(String restaurantUsername) {
        return serviceOrderRepository.findByRestaurantUsername(restaurantUsername);
    }

    @Override
    public List<ServiceOrder> findByCustomerEmail(String customerEmail) {
        return serviceOrderRepository.findByCustomerEmail(customerEmail);
    }

    @Override
    public ServiceOrder findById(String id) {
        return serviceOrderRepository.findById(id);
    }

    @Override
    public int save(ServiceOrder serviceOrder) {
        //serviceOrder.setId(UUID.randomUUID().toString());
        return serviceOrderRepository.save(serviceOrder);
    }

    @Override
    public int delete(String id) {
        return serviceOrderRepository.delete(id);
    }
}
