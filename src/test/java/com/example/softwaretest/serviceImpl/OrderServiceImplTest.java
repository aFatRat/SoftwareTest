package com.example.softwaretest.serviceImpl;

import com.example.softwaretest.DAO.BookDAO;
import com.example.softwaretest.DAO.CartDAO;
import com.example.softwaretest.DAO.OrderDAO;
import com.example.softwaretest.DAO.UserDAO;
import com.example.softwaretest.entity.Book;
import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.entity.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private UserDAO userDAO;

    @Mock
    private OrderDAO orderDAO;

    @Mock
    private BookDAO bookDAO;

    @Mock
    private CartDAO cartDAO;

    @Test
    public void testGetOrder() {
        // 模拟一个订单对象
        Order mockOrder = new Order();
        mockOrder.setId(1); // 设置一个已知的订单 ID

        // 当调用 orderDAO.findOrderByOrderId() 时返回模拟的订单对象
        when(orderDAO.findOrderByOrderId(1)).thenReturn(mockOrder);

        // 调用 getOrder() 方法
        Order result = orderService.getOrder(1);

        // 断言返回的订单对象不为空
        assertNotNull(result);
        // 断言返回的订单对象与模拟的订单对象相同
        assertEquals(mockOrder, result);
    }

    @Test
    public void testGetAllOrders() {
        // 模拟一个用户 ID
        int userId = 1;

        // 模拟一个订单列表
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order());
        mockOrders.add(new Order());

        // 当调用 orderDAO.findOrderByUserId() 时返回模拟的订单列表
        when(orderDAO.findOrderByUserId(userId)).thenReturn(mockOrders);

        // 调用 getAllOrders() 方法
        List<Order> result = orderService.getAllOrders(userId);

        // 断言返回的订单列表不为空
        assertNotNull(result);
        // 断言返回的订单列表与模拟的订单列表相同
        assertEquals(mockOrders, result);
    }

    @Test
    public void testAddOrder() {
        // 模拟添加订单的参数
        int userId = 1;
        List<Map<String, Integer>> params = new ArrayList<>();
        params.add(Map.of("bookId", 1, "number", 2));
        params.add(Map.of("bookId", 2, "number", 1));

        // 模拟一个书籍对象
        Book mockBook1 = new Book();
        mockBook1.setId(1);
        mockBook1.setName("Test Book1");
        mockBook1.setPrice(new BigDecimal("10.99"));

        Book mockBook2 = new Book();
        mockBook2.setId(2);
        mockBook2.setName("Test Book2");
        mockBook2.setPrice(new BigDecimal("12.99"));

        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setId(1);

        // 当调用 bookDAO.findBookByBookId() 时返回模拟的书籍对象
        when(bookDAO.findBookByBookId(1)).thenReturn(mockBook1);
        when(bookDAO.findBookByBookId(2)).thenReturn(mockBook2);
        // 当调用 cartDAO.findCartByUserId() 时返回模拟的购物车对象
        when(cartDAO.findCartByUserId(userId)).thenReturn(mockCart);

        // 调用 addOrder() 方法
        Order result = orderService.addOrder(userId, params);

        // 断言返回的订单对象不为空
        assertNotNull(result);
        // 断言订单对象的用户 ID 与参数中的用户 ID 相同
        assertEquals(userId, result.getUserId());
    }
}