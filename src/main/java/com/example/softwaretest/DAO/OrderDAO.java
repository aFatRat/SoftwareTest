package com.example.softwaretest.DAO;

import com.example.softwaretest.entity.Order;
import com.example.softwaretest.entity.OrderItem;

import java.util.List;
import java.util.Set;

public interface OrderDAO {
    Order findOrderByOrderId(int orderId);
    List<Order> findOrderByUserId(int userId);
    List<OrderItem> findOrderItemByOrderId(int orderId);

    void save(Order order);

    void saveItems(Set<OrderItem> orderItems);
}
