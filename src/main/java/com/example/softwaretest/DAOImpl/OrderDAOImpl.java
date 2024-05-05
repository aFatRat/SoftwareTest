package com.example.softwaretest.DAOImpl;

import com.example.softwaretest.DAO.OrderDAO;
import com.example.softwaretest.entity.Order;
import com.example.softwaretest.entity.OrderItem;
import com.example.softwaretest.repository.OrderItemRepository;
import com.example.softwaretest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public Order findOrderByOrderId(int orderId) {
        Optional<Order> order=orderRepository.findById(orderId);
        return order.orElse(null);
    }

    @Override
    public List<Order> findOrderByUserId(int userId) {
        return orderRepository.findOrderByUserId(userId);
    }
    @Override
    public List<OrderItem> findOrderItemByOrderId(int orderId) {
        return orderItemRepository.findOrderItemByOrderId(orderId);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void saveItems(Set<OrderItem> orderItems) {
        orderItemRepository.saveAll(orderItems);
    }
}
