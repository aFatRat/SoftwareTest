package com.example.softwaretest.DAOImpl;

import com.example.softwaretest.DAO.CartDAO;
import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.entity.CartItem;
import com.example.softwaretest.repository.CartItemRepository;
import com.example.softwaretest.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartDAOImpl implements CartDAO {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Override
    public Cart findCartByUserId(int userId) {
        Optional<Cart> cart=cartRepository.findCartByUserId(userId);
        return cart.orElse(null);
    }

    @Override
    public List<CartItem> findCartItemByCartId(int cartId) {
        return cartItemRepository.findCartItemByCartId(cartId);
    }

    @Override
    public void saveItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteItems(List<CartItem> cartItems) {
        cartItemRepository.deleteAll(cartItems);
    }

    @Override
    public void deleteItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
