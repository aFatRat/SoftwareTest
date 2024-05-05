package com.example.softwaretest.DAO;

import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;

public interface UserDAO {
    User findUserByUserId(int userId);
    UserAuth findUserAuthByUsername(String username);
    UserAuth findUserAuthByUsernameAndPassword(String username,String password);
}
