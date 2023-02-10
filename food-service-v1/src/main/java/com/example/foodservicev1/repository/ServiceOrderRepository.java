package com.example.foodservicev1.repository;

import com.example.foodservicev1.entity.ServiceOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderRepository {
    public List<ServiceOrder> find();
    public List<ServiceOrder> findByRestaurantUsername(String restaurantUsername);
    public List<ServiceOrder> findByCustomerEmail(String customerEmail);
    public ServiceOrder findById(String id);
    public int save(ServiceOrder serviceOrder);
    public int update(ServiceOrder serviceOrder);
    public int delete(String id);
}
