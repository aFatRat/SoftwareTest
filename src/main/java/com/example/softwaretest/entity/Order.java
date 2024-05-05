package com.example.softwaretest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "orders", schema = "mybookstore", catalog = "")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Basic
    @Column(name = "time")
    private String time;
    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true)

//@OneToMany(cascade = CascadeType.PERSIST)
//@JoinTable(name="order_items",
//        joinColumns = @JoinColumn(name = "order_id"),
//        inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<OrderItem> orderItemSet=new LinkedHashSet<>();

    public Order(int userId,BigDecimal totalPrice,String time){
        this.userId=userId;
        this.totalPrice=totalPrice;
        this.time=time;
    }

    public Order(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && userId == order.userId && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, totalPrice, time);
    }
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Order order = (Order) o;
//        return orderId == order.orderId && userId == order.userId && Objects.equals(price, order.price) && Objects.equals(time, order.time);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderId, userId, price, time);
//    }
}
