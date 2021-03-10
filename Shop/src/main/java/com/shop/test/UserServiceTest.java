package com.shop.test;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 19:08
 * @Version 1.0
 * @describe
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser(){
        userService.registUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }
}
