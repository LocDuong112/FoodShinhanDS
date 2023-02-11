package com.example.foodservicev1.controller;

import com.example.foodservicev1.entity.ServiceOrder;
import com.example.foodservicev1.service.AIChatService;
import com.example.foodservicev1.service.OrderFoodService;
import com.example.foodservicev1.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private OrderFoodService orderFoodService;

    @Autowired
    private AIChatService aiChatService;

    @PostMapping("/api/test/order")
    public int saveOrder(@RequestBody ServiceOrder serviceOrder) {
        return serviceOrderService.save(serviceOrder);
    }

    @GetMapping("/api/test/order/{restaurantUsername}")
    public List<ServiceOrder> saveOrder(@PathVariable String restaurantUsername) {
        System.out.println(serviceOrderService.findByRestaurantUsername(restaurantUsername).get(0));
        return serviceOrderService.findByRestaurantUsername(restaurantUsername);
    }

    @GetMapping("/api/customer/chat/request2")
    public String aIChatResponse2() {
        return aiChatService.chatResponse("How can I learn Spring Boot");
    }

    /*@PostMapping("/api/customer/order")
    public String addOrder(@RequestParam List<String> foodIdList,
                           @RequestParam List<Integer> quantityList,
                           @RequestParam String restaurantUsername) {

        String uniqueID = UUID.randomUUID().toString();

        List<Food> foods = new ArrayList<>();
        List<OrderFood> orderFoods = new ArrayList<>();

        serviceOrderService.save(new ServiceOrder(uniqueID, restaurantUsername, "theboost1305@gmail.com", null));

        for (int i = 0; i < foodIdList.size(); i++) {
            orderFoodService.save(new OrderFood(uniqueID, foodIdList.get(i), quantityList.get(i)));
        }

        return "Hi";


    }*/
}
