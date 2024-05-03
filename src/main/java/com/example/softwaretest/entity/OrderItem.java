package com.example.softwaretest.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "mybookstore", catalog = "")
public class OrderItem {
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_item_id")
    private int orderItemId;
    @Basic
    @Column(name = "book_id")
    private Integer bookId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderId == orderItem.orderId && orderItemId == orderItem.orderItemId && Objects.equals(bookId, orderItem.bookId) && Objects.equals(name, orderItem.name) && Objects.equals(number, orderItem.number) && Objects.equals(totalPrice, orderItem.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderItemId, bookId, name, number, totalPrice);
    }
}
