package com.example.softwaretest.DAOImpl;

import com.example.softwaretest.DAO.UserDAO;
import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import com.example.softwaretest.repository.UserAuthRepository;
import com.example.softwaretest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAuthRepository userAuthRepository;
    @Override
    public User findUserByUserId(int userId) {
        Optional<User> user=userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public UserAuth findUserAuthByUsername(String username) {
        Optional<UserAuth> userAuth=userAuthRepository.findUserAuthByUsername(username);
        return userAuth.orElse(null);
    }

    @Override
    public UserAuth findUserAuthByUsernameAndPassword(String username, String password) {
        Optional<UserAuth> userAuth=userAuthRepository.findUserAuthByUsernameAndPassword(username,password);
        return userAuth.orElse(null);
    }
}
