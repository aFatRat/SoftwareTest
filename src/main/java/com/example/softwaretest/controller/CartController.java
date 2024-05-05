package com.example.softwaretest.controller;

import com.example.softwaretest.entity.Cart;
import com.example.softwaretest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("/getCart")
    @CrossOrigin
    public Cart getCart(@RequestParam int userId) {
        return cartService.getCart(userId);
    }

    @RequestMapping("/addBookToCart")
    @CrossOrigin
    public void addBookToCart(@RequestParam int userId, @RequestParam int bookId) {
        cartService.addBookToCart(userId,bookId);
    }

    @RequestMapping("/removeBookInCart")
    @CrossOrigin
    public Cart removeBookInCart(@RequestParam int userId, @RequestParam int bookId) {
        return cartService.removeBookInCart(userId,bookId);
    }

}
