package com.example.softwaretest.repository;

import com.example.softwaretest.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
   List<CartItem> findCartItemByCartId(int cartId);
   List<CartItem> findCartItemByCartIdAndBookId(int cartId,int bookId);
}
