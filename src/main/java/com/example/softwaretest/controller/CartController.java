package com.example.softwaretest.controller;

import com.example.softwaretest.entity.CartItem;
import com.example.softwaretest.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @RequestMapping("/getCart")
    @CrossOrigin
    public List<CartItem> getCart(@RequestParam int userId){
        List<CartItem> result;
        result=cartRepository.findByUserIdIs(userId);
        return result;
    }

    @RequestMapping("/addBookToCart")
    @CrossOrigin
    public void addBookToCart(@RequestParam int userId,@RequestParam int bookId){
        List<CartItem> result;
        CartItem c = new CartItem(userId,bookId,1);
        result=cartRepository.findByUserIdIs(userId);
        for(CartItem cartItem : result){
            if(cartItem.getBookId()==bookId){
                cartItem.setNumber(cartItem.getNumber()+1);
                c=cartItem;
                break;
            }
        }
        cartRepository.save(c);
    }

    @RequestMapping("/removeBookInCart")
    @CrossOrigin
    public void removeBookInCart(@RequestParam int userId,@RequestParam int bookId){
        List<CartItem> cartItems;
        cartItems=cartRepository.findByUserIdIs(userId);
        for(CartItem cartItem:cartItems){
            if(cartItem.getBookId()==bookId){
                cartRepository.delete(cartItem);
                break;
            }
        }
    }

}
