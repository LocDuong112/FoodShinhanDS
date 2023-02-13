package com.example.restaurantmanagementjavaspringboot.service.impl;

import com.example.restaurantmanagementjavaspringboot.converter.OrderMapper;
import com.example.restaurantmanagementjavaspringboot.dto.OrderDto;
import com.example.restaurantmanagementjavaspringboot.entity.Order;
import com.example.restaurantmanagementjavaspringboot.repository.OrderRepository;
import com.example.restaurantmanagementjavaspringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Resource
    private OrderMapper orderMapper;
    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
        for( Order order : orders){
            if(Objects.isNull(order)){
                return null;
            }
            OrderDto orderDto = orderMapper.entityToDto(order);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.dtoToEntity(orderDto);
        order = orderRepository.save(order);
        return orderMapper.entityToDto(order);
    }
    @Override
    public OrderDto findById(long id) {
        Order _order = orderRepository.findById(id).orElse(null);
        return orderMapper.entityToDto(_order);
    }

}
