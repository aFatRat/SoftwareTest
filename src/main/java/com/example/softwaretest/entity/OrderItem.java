package com.example.softwaretest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table(name = "order_items", schema = "mybookstore", catalog = "")
public class OrderItem {
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
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
    @Column(name = "price")
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name="book_id",insertable = false,updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    @JsonIgnore
//@ManyToOne(targetEntity = Order.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//@JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderId == orderItem.orderId && id == orderItem.id && Objects.equals(bookId, orderItem.bookId) && Objects.equals(name, orderItem.name) && Objects.equals(number, orderItem.number) && Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, id, bookId, name, number, price);
    }
}
