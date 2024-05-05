package com.example.softwaretest.serviceImpl;

import com.example.softwaretest.DAO.CartDAO;
import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.entity.CartItem;
import com.example.softwaretest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDAO cartDAO;
    @Override
    public Cart getCart(int userId) {
        return cartDAO.findCartByUserId(userId);
    }

    @Override
    public void addBookToCart(int userId, int bookId) {
        Cart cart = cartDAO.findCartByUserId(userId);
        int cartId = cart.getId();
        List<CartItem> cartItems = cartDAO.findCartItemByCartId(cartId);
        CartItem c = new CartItem(userId, bookId, 1);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getBookId() == bookId) {
                cartItem.setNumber(cartItem.getNumber() + 1);
                c = cartItem;
                break;
            }
        }
        cartDAO.saveItem(c);
    }

    @Override
    public Cart removeBookInCart(int userId, int bookId) {
        Cart cart = cartDAO.findCartByUserId(userId);
        int cartId = cart.getId();
        List<CartItem> cartItems=cartDAO.findCartItemByCartId(cartId);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getBookId() == bookId) {
                cartDAO.deleteItem(cartItem);
                break;
            }
        }
        return cartDAO.findCartByUserId(userId);
    }
}
