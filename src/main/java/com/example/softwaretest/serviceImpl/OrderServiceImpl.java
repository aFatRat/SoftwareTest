package com.example.softwaretest.serviceImpl;

import com.example.softwaretest.DAO.BookDAO;
import com.example.softwaretest.DAO.CartDAO;
import com.example.softwaretest.DAO.OrderDAO;
import com.example.softwaretest.DAO.UserDAO;
import com.example.softwaretest.entity.*;
import com.example.softwaretest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CartDAO cartDAO;

    @Override
    public Order getOrder(int orderId) {
        return orderDAO.findOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getAllOrders(int userId) {
        return orderDAO.findOrderByUserId(userId);
    }

    @Override
    public Order addOrder(int userId, List<Map<String, Integer>> params) {
        Date now = new Date();
        Order order = new Order();
        Set<OrderItem> orderItems = new HashSet<>();
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map<String, Integer> map : params) {
            int bookId = map.get("bookId");
            int number = map.get("number");
            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
            orderItem.setNumber(number);
            orderItem.setBookId(bookId);
            Book book = bookDAO.findBookByBookId(bookId);
            orderItem.setName(book.getName());
            BigDecimal thisPrice = book.getPrice().multiply(new BigDecimal(number));
            orderItem.setPrice(thisPrice);
            totalPrice = totalPrice.add(thisPrice);
            orderItems.add(orderItem);
        }
        order.setTotalPrice(totalPrice);
        order.setTime(now.toString());
        order.setUserId(userId);
        orderDAO.save(order);
        for (OrderItem item : orderItems) {
            item.setOrderId(order.getId());
        }
        orderDAO.saveItems(orderItems);

        Cart cart = cartDAO.findCartByUserId(userId);
        int cartId = cart.getId();
        List<CartItem> cartItems = cartDAO.findCartItemByCartId(cartId);
        cartDAO.deleteItems(cartItems);

        return order;
    }
}
