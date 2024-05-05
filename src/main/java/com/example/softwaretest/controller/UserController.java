package com.example.softwaretest.controller;

import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import com.example.softwaretest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @CrossOrigin
    public UserAuth login(@RequestBody Map<String, String> params) {
        return userService.login(params);
    }

    @RequestMapping("/getUser")
    @CrossOrigin
    public User getUser(@RequestBody Map<String, String> params) {
        return userService.getUserByUsernameAndPassword(params);
    }
}
