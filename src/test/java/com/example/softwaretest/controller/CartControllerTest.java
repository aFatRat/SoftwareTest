package com.example.softwaretest.controller;

import static org.junit.Assert.*;

import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class CartControllerTest {

    @InjectMocks
    private CartController cartController;

    @Mock
    private CartService cartService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCart() {
        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setUserId(1); // 设置一个已知的用户 ID

        // 当调用 cartService.getCart() 时返回模拟的购物车对象
        when(cartService.getCart(1)).thenReturn(mockCart);

        // 调用 getCart() 方法
        Cart result = cartController.getCart(1);

        // 断言返回的购物车对象不为空
        assertNotNull(result);
        // 断言返回的购物车对象与模拟的购物车对象相同
        assertEquals(mockCart, result);
    }

    @Test
    public void testAddBookToCart() {
        // 调用 addBookToCart() 方法
        cartController.addBookToCart(1, 1);

        // 验证 cartService.addBookToCart() 方法被调用了一次
        verify(cartService, times(1)).addBookToCart(1, 1);
    }

    @Test
    public void testRemoveBookInCart() {
        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setUserId(1); // 设置一个已知的用户 ID

        // 当调用 cartService.removeBookInCart() 时返回模拟的购物车对象
        when(cartService.removeBookInCart(1, 1)).thenReturn(mockCart);

        // 调用 removeBookInCart() 方法
        Cart result = cartController.removeBookInCart(1, 1);

        // 断言返回的购物车对象不为空
        assertNotNull(result);
        // 断言返回的购物车对象与模拟的购物车对象相同
        assertEquals(mockCart, result);
    }
}

