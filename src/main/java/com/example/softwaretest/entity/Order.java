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
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "time")
    private String time;

    @OneToMany
    @JoinTable(name="order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_item_id"))
    private Set<OrderItem> orderItemSet=new LinkedHashSet<>();

    public Order(int userId,BigDecimal price,String time){
        this.userId=userId;
        this.price=price;
        this.time=time;
    }

    public Order(){

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
