package com.example.softwaretest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "carts", schema = "mybookstore", catalog = "")
public class CartItem {
    @Basic
    @Column(name = "user_id")
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_item_id")
    private int cartItemId;
    @Basic
    @Column(name = "book_id")
    private Integer bookId;
    @Basic
    @Column(name = "number")
    private Integer number;

    public CartItem(int userId,int bookId,int number){
        this.userId=userId;
        this.bookId=bookId;
        this.number=number;
    }

    public CartItem(int userId,int bookId){
        this.userId=userId;
        this.bookId=bookId;
    }

    public CartItem(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return userId == cartItem.userId && cartItemId == cartItem.cartItemId && Objects.equals(bookId, cartItem.bookId) && Objects.equals(number, cartItem.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cartItemId, bookId, number);
    }
}
