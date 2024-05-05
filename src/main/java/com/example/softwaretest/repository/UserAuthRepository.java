package com.example.softwaretest.repository;

import com.example.softwaretest.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth,Integer> {
    Optional<UserAuth> findUserAuthByUsername(String username);
    Optional<UserAuth> findUserAuthByUsernameAndPassword(String username,String password);
}
