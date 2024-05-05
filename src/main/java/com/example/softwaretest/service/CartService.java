package com.example.softwaretest.service;

import com.example.softwaretest.entity.Cart;


import java.util.Optional;

public interface CartService {
    Cart getCart(int userId);
    void addBookToCart(int userId, int bookId);

    Cart removeBookInCart(int userId, int bookId);
}
