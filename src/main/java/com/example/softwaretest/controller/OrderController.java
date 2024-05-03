package com.example.softwaretest.controller;

import com.example.softwaretest.entity.Book;
import com.example.softwaretest.entity.CartItem;
import com.example.softwaretest.entity.Order;
import com.example.softwaretest.entity.OrderItem;
import com.example.softwaretest.repository.BookRepository;
import com.example.softwaretest.repository.CartRepository;
import com.example.softwaretest.repository.OrderItemRepository;
import com.example.softwaretest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CartRepository cartRepository;
    @RequestMapping("/getOrder")
    @CrossOrigin
    public Optional<Order> getOrder(@RequestParam int orderId){
        Optional<Order> result;
        result=orderRepository.findById(orderId);
        return result;
    }

    @RequestMapping("/getAllOrders")
    @CrossOrigin
    public List<Order> getAllOrders(@RequestParam int userId){
        List<Order> result;
        result=orderRepository.findOrderByUserIdIs(userId);
        return result;
    }

    @RequestMapping("/addOrder")
    @CrossOrigin
    public Order addOrder(@RequestBody Order order){
        Date now=new Date();
        Set<OrderItem> orderItems = new HashSet<>();
        BigDecimal totalPrice=new BigDecimal(0);
        for(OrderItem orderItem:order.getOrderItemSet()){
            Optional<Book> result;
            result=bookRepository.findById(orderItem.getBookId());
            BigDecimal price=result.get().getPrice().multiply(new BigDecimal(orderItem.getNumber()));
            orderItem.setTotalPrice(price);
            orderItem.setName(result.get().getName());
            totalPrice=totalPrice.add(price);
            orderItems.add(orderItem);
        }
        Order newOrder=new Order(order.getUserId(),totalPrice,now.toString());
        order.setPrice(totalPrice);
        orderRepository.save(newOrder);
        for (OrderItem orderItem : orderItems){
            orderItem.setOrderId(newOrder.getOrderId());
            orderItemRepository.save(orderItem);
            List<CartItem> cartItem= cartRepository.findByUserIdAndBookId(order.getUserId(),orderItem.getBookId());
            cartRepository.delete(cartItem.get(0));
        }

        order.setTime(now.toString());
        order.setOrderItemSet(orderItems);
        order.setOrderId(newOrder.getOrderId());
        return order;
    }
}
