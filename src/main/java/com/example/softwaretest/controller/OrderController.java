package com.example.softwaretest.controller;

import com.example.softwaretest.entity.*;
import com.example.softwaretest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrder")
    @CrossOrigin
    public Order getOrder(@RequestParam int orderId) {
        return orderService.getOrder(orderId);
    }

    @RequestMapping("/getAllOrders")
    @CrossOrigin
    public List<Order> getAllOrders(@RequestParam int userId) {
        return orderService.getAllOrders(userId);
    }

    @RequestMapping("/addOrder")
    @CrossOrigin
    public Order addOrder(@RequestParam int userId, @RequestBody List<Map<String, Integer>> params) {
        return orderService.addOrder(userId, params);
    }
}
