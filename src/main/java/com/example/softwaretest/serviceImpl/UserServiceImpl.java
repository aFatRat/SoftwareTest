package com.example.softwaretest.serviceImpl;

import com.example.softwaretest.DAO.UserDAO;
import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import com.example.softwaretest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;


    @Override
    public UserAuth login(Map<String, String> params) {
        String username=params.get("username");
        String password=params.get("password");
        UserAuth userAuth=userDAO.findUserAuthByUsername(username);

        if(Objects.equals(userAuth.getPassword(), password))
            return userAuth;
        else {
            return new UserAuth(0,username,password,"");
        }
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDAO.findUserByUserId(userId);
    }

    @Override
    public User getUserByUsernameAndPassword(Map<String, String> params) {
        User user;
        UserAuth userAuth;
        String username = params.get("username");
        String password = params.get("password");
        userAuth = userDAO.findUserAuthByUsernameAndPassword(username, password);
        int userId = userAuth.getUserId();
        user = userDAO.findUserByUserId(userId);
        return user;
    }


}
