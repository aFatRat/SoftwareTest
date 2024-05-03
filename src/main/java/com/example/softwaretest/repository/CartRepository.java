package com.example.softwaretest.repository;


import com.example.softwaretest.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUserIdIs(int id);
    List<CartItem> findByUserIdAndBookId(int userId, int bookId);

}
