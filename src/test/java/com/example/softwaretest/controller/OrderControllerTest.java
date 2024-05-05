package com.example.softwaretest.controller;

import com.example.softwaretest.entity.Order;
import com.example.softwaretest.service.OrderService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testGetOrder() {
        // 模拟一个订单对象
        Order mockOrder = new Order();
        mockOrder.setId(1); // 设置一个已知的订单 ID

        // 当调用 orderService.getOrder() 时返回模拟的订单对象
        when(orderService.getOrder(1)).thenReturn(mockOrder);

        // 调用 getOrder() 方法
        Order result = orderController.getOrder(1);

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
        List<Order> mockOrders = Arrays.asList(new Order(), new Order());

        // 当调用 orderService.getAllOrders() 时返回模拟的订单列表
        when(orderService.getAllOrders(userId)).thenReturn(mockOrders);

        // 调用 getAllOrders() 方法
        List<Order> result = orderController.getAllOrders(userId);

        // 断言返回的订单列表不为空
        assertNotNull(result);
        // 断言返回的订单列表与模拟的订单列表相同
        assertEquals(mockOrders, result);
    }

    @Test
    public void testAddOrder() {
        // 模拟添加订单的参数
        int userId = 1;
        List<Map<String, Integer>> params = Arrays.asList(
                Map.of("productId", 1, "quantity", 2),
                Map.of("productId", 2, "quantity", 1)
        );

        // 模拟添加订单后返回的订单对象
        Order mockOrder = new Order();
        mockOrder.setId(1); // 设置一个已知的订单 ID

        // 当调用 orderService.addOrder() 时返回模拟的订单对象
        when(orderService.addOrder(userId, params)).thenReturn(mockOrder);

        // 调用 addOrder() 方法
        Order result = orderController.addOrder(userId, params);

        // 断言返回的订单对象不为空
        assertNotNull(result);
        // 断言返回的订单对象与模拟的订单对象相同
        assertEquals(mockOrder, result);
    }
}