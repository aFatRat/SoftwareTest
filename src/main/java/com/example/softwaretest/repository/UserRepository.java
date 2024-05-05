package com.example.softwaretest.repository;


import com.example.softwaretest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
}
