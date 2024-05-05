package com.example.softwaretest.controller;

import static org.junit.Assert.*;

import com.example.softwaretest.entity.User;
import com.example.softwaretest.entity.UserAuth;
import com.example.softwaretest.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() {
        // 模拟登录参数
        Map<String, String> params = new HashMap<>();
        params.put("username", "jerry");
        params.put("password", "jerry123");

        // 模拟登录返回结果
        UserAuth mockUserAuth = new UserAuth();
        mockUserAuth.setUserId(1);
        mockUserAuth.setUsername("jerry");

        // 当调用 userService.login() 时返回模拟的用户认证对象
        when(userService.login(params)).thenReturn(mockUserAuth);

        // 调用 login() 方法
        UserAuth result = userController.login(params);

        // 断言返回的用户认证对象不为空
        assertNotNull(result);
        // 断言返回的用户认证对象与模拟的用户认证对象相同
        assertEquals(mockUserAuth, result);
    }

    @Test
    public void testGetUser() {
        // 模拟获取用户参数
        Map<String, String> params = new HashMap<>();
        params.put("username", "jerry");
        params.put("password", "jerry123");

        // 模拟用户对象
        User mockUser = new User();
        mockUser. setId(1);
        mockUser.setName("jerry");

        // 当调用 userService.getUserByUsernameAndPassword() 时返回模拟的用户对象
        when(userService.getUserByUsernameAndPassword(params)).thenReturn(mockUser);

        // 调用 getUser() 方法
        User result = userController.getUser(params);

        // 断言返回的用户对象不为空
        assertNotNull(result);
        // 断言返回的用户对象与模拟的用户对象相同
        assertEquals(mockUser, result);
    }
}
