package com.example.softwaretest.service;

import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    UserAuth login(Map<String,String> params);
    User getUserByUserId(int userId);
    User getUserByUsernameAndPassword(Map<String,String> params);
}
