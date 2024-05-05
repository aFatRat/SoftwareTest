package com.example.softwaretest.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_auth", schema = "mybookstore", catalog = "")
public class UserAuth {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    public UserAuth(){};
    public UserAuth(int userId,String username,String password,String userType){
        this.userId=userId;
        this.username=username;
        this.password=password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuth userAuth = (UserAuth) o;
        return userId == userAuth.userId && Objects.equals(username, userAuth.username) && Objects.equals(password, userAuth.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password);
    }
}
