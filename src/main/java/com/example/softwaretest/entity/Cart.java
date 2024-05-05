package com.example.softwaretest.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carts", schema = "mybookstore", catalog = "")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, orphanRemoval = false)
    private Set<CartItem> cartItemSet=new LinkedHashSet<>();

    public Set<CartItem> getCartItemSet() {
        return cartItemSet;
    }

    public void setCartItemSet(Set<CartItem> cartItemSet) {
        this.cartItemSet = cartItemSet;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && userId == cart.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
