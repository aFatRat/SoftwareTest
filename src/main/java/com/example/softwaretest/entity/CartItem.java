package com.example.softwaretest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "cart_items", schema = "mybookstore", catalog = "")
public class CartItem {
    @Basic
    @Column(name = "cart_id")
    private int cartId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "book_id")
    private Integer bookId;
    @Basic
    @Column(name = "number")
    private Integer number;
    @ManyToOne
    @JoinColumn(name = "cart_id",insertable = false,updatable = false)
    @JsonIgnore
    private Cart cart;

    @OneToOne
    @JoinColumn(name="book_id",insertable = false,updatable = false)
    private Book book;
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartItem(){};
    public CartItem(int cartId,int bookID,int number){
        this.cartId=cartId;
        this.bookId=bookID;
        this.number=number;
    }
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return cartId == cartItem.cartId && id == cartItem.id && Objects.equals(bookId, cartItem.bookId) && Objects.equals(number, cartItem.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, id, bookId, number);
    }
}
