package com.example.softwaretest.serviceImpl;

import static org.junit.Assert.*;

import com.example.softwaretest.DAO.CartDAO;
import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.entity.CartItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImplTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartDAO cartDAO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCart() {
        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setUserId(1); // 设置一个已知的用户 ID

        // 当调用 cartDAO.findCartByUserId() 时返回模拟的购物车对象
        when(cartDAO.findCartByUserId(1)).thenReturn(mockCart);

        // 调用 getCart() 方法
        Cart result = cartService.getCart(1);

        // 断言返回的购物车对象不为空
        assertNotNull(result);
        // 断言返回的购物车对象与模拟的购物车对象相同
        assertEquals(mockCart, result);
    }

    @Test
    public void testAddBookToCart() {
        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setId(1);
        mockCart.setUserId(1);

        // 模拟一个购物车商品列表
        List<CartItem> mockCartItems = new ArrayList<>();
        mockCartItems.add(new CartItem(1, 1, 1));

        // 当调用 cartDAO.findCartByUserId() 时返回模拟的购物车对象
        when(cartDAO.findCartByUserId(1)).thenReturn(mockCart);
        // 当调用 cartDAO.findCartItemByCartId() 时返回模拟的购物车商品列表
        when(cartDAO.findCartItemByCartId(1)).thenReturn(mockCartItems);

        // 调用 addBookToCart() 方法
        cartService.addBookToCart(1, 2);

        // 验证 cartDAO.saveItem() 方法被调用了一次
        verify(cartDAO, times(1)).saveItem(any(CartItem.class));
    }

    @Test
    public void testRemoveBookInCart() {
        // 模拟一个购物车对象
        Cart mockCart = new Cart();
        mockCart.setId(1);
        mockCart.setUserId(1);

        // 模拟一个购物车商品列表
        List<CartItem> mockCartItems = new ArrayList<>();
        mockCartItems.add(new CartItem(1, 1, 1));
        mockCartItems.add(new CartItem(1, 2, 1));

        // 当调用 cartDAO.findCartByUserId() 时返回模拟的购物车对象
        when(cartDAO.findCartByUserId(1)).thenReturn(mockCart);
        // 当调用 cartDAO.findCartItemByCartId() 时返回模拟的购物车商品列表
        when(cartDAO.findCartItemByCartId(1)).thenReturn(mockCartItems);

        // 调用 removeBookInCart() 方法
        Cart result = cartService.removeBookInCart(1, 2);

        // 验证 cartDAO.deleteItem() 方法被调用了一次
        verify(cartDAO, times(1)).deleteItem(any(CartItem.class));
        // 验证返回的购物车对象不为空
        assertNotNull(result);
    }
}
