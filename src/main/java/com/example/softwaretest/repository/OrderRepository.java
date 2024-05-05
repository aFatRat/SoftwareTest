package com.example.softwaretest.repository;

import com.example.softwaretest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findOrderByUserId(int userId);
}
