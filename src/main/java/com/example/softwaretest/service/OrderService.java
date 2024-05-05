package com.example.softwaretest.service;

import com.example.softwaretest.entity.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Order getOrder(int orderId);
    List<Order> getAllOrders(int userId);
    Order addOrder(int userId, List<Map<String, Integer>> params);
}
