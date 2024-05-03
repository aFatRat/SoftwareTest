package com.example.softwaretest.controller;

import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import com.example.softwaretest.repository.UserAuthRepository;
import com.example.softwaretest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAuthRepository userAuthRepository;

    @RequestMapping("/login")
    @CrossOrigin
    public int login(@RequestParam String username,@RequestParam String password){
        Optional<UserAuth> result;
        result=userAuthRepository.findUserAuthByUsernameIs(username);
        if(result.filter(userAuth -> (Objects.equals(password, userAuth.getPassword()))).isPresent())
            return result.get().getUserId();
        else return 0;
    }

    @RequestMapping("/getUser")
    @CrossOrigin
    public Optional<User> getUser(@RequestParam int userId){
        Optional<User> result;
        result=userRepository.findById(userId);
        return result;
    }
}
