package com.example.softwaretest.serviceImpl;

import static org.junit.Assert.*;

import com.example.softwaretest.DAO.UserDAO;
import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDAO userDAO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin_ValidCredentials() {
        // 模拟登录参数
        Map<String, String> params = new HashMap<>();
        params.put("username", "jerry");
        params.put("password", "jerry123");

        // 模拟用户认证对象
        UserAuth mockUserAuth = new UserAuth();
        mockUserAuth.setUserId(1);
        mockUserAuth.setUsername("jerry");
        mockUserAuth.setPassword("jerry123");

        // 当调用 userDAO.findUserAuthByUsername() 时返回模拟的用户认证对象
        when(userDAO.findUserAuthByUsername("jerry")).thenReturn(mockUserAuth);

        // 调用 login() 方法
        UserAuth result = userService.login(params);

        // 断言返回的用户认证对象不为空
        assertNotNull(result);
        // 断言返回的用户认证对象与模拟的用户认证对象相同
        assertEquals(mockUserAuth, result);
    }

    @Test
    public void testLogin_InvalidCredentials() {
        // 模拟登录参数
        Map<String, String> params = new HashMap<>();
        params.put("username", "jerry");
        params.put("password", "jerry");

        // 模拟用户认证对象
        UserAuth mockUserAuth = new UserAuth();
        mockUserAuth.setUserId(1);
        mockUserAuth.setUsername("jerry");
        mockUserAuth.setPassword("jerry123");

        // 当调用 userDAO.findUserAuthByUsername() 时返回模拟的用户认证对象
        when(userDAO.findUserAuthByUsername("jerry")).thenReturn(mockUserAuth);

        // 调用 login() 方法
        UserAuth result = userService.login(params);

        // 断言返回的用户认证对象不为空
        assertNotNull(result);
        // 断言返回的用户认证对象的用户 ID 为 0，表示登录失败
        assertEquals(0, result.getUserId());
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        // 模拟登录参数
        Map<String, String> params = new HashMap<>();
        params.put("username", "jerry");
        params.put("password", "jerry123");

        // 模拟用户对象
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("jerry");
        //mockUser.setPassword("testPassword");

        // 模拟用户认证对象
        UserAuth mockUserAuth = new UserAuth();
        mockUserAuth.setUserId(1);
        mockUserAuth.setUsername("jerry");
        mockUserAuth.setPassword("jerry123");

        // 当调用 userDAO.findUserAuthByUsernameAndPassword() 时返回模拟的用户认证对象
        when(userDAO.findUserAuthByUsernameAndPassword("jerry", "jerry123")).thenReturn(mockUserAuth);
        // 当调用 userDAO.findUserByUserId() 时返回模拟的用户对象
        when(userDAO.findUserByUserId(1)).thenReturn(mockUser);

        // 调用 getUserByUsernameAndPassword() 方法
        User result = userService.getUserByUsernameAndPassword(params);

        // 断言返回的用户对象不为空
        assertNotNull(result);
        // 断言返回的用户对象与模拟的用户对象相同
        assertEquals(mockUser, result);
    }
}

