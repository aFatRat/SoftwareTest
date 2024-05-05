package com.example.softwaretest.DAO;

import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.entity.CartItem;

import java.util.List;

public interface CartDAO {
    Cart findCartByUserId(int userId);
    List<CartItem> findCartItemByCartId(int cartId);

    void saveItem(CartItem cartItem);

    void deleteItems(List<CartItem> cartItems);

    void deleteItem(CartItem cartItem);
}
