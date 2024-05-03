package com.example.softwaretest.repository;

import com.example.softwaretest.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findOrderItemByOrderIdIs(int orderId);
}
